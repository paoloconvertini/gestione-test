package com.jsb.gestionepianificazione.service;

import com.jsb.gestionepianificazione.dto.PianificatoDTO;
import com.jsb.gestionepianificazione.dto.PianificatoDipendenteDTO;
import com.jsb.gestionepianificazione.entity.Pianificato;
import com.jsb.gestionepianificazione.mapper.PianificatoMapper;
import com.jsb.gestionepianificazione.service.api.IPianificatoService;
import org.apache.commons.lang3.tuple.Pair;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.jsb.gestionepianificazione.constant.DatabaseConstant.*;

@ApplicationScoped
public class PianificatoServiceImpl implements IPianificatoService {

    @Inject
    EntityManager entityManager;

    @Inject
    PianificatoMapper pianificatoMapper;

    @Transactional
    @Override
    public void savePianificato(PianificatoDTO dto) {
        List<Pianificato> pianificatoList = pianificatoMapper.fromDTOtoEntity(dto);
        List<Pianificato> listFromDb =
                entityManager.createNamedQuery(PIANIFICATO_FIND_BY_ID_PROGETTO, Pianificato.class)
                        .setParameter(ID_PROGETTO, dto.getIdProgetto())
                        .getResultList();
        // DELETE
        listFromDb.removeAll(pianificatoList);
        listFromDb.forEach(l -> entityManager.remove(l));
        pianificatoList.forEach(pianificato -> {
            try {
                Pianificato entity = entityManager.createNamedQuery(PIANIFICATO_FIND_BY_FK, Pianificato.class)
                        .setParameter(ID_PROGETTO, pianificato.getProgetto().getId())
                        .setParameter(ID_DIPENDENTE, pianificato.getDipendente().getId())
                        .setParameter(FLAG_PROGRAMMATO, pianificato.getFlagProgrammato())
                        .getSingleResult();
                //UPDATE
                pianificatoMapper.updateEntity(entity, pianificato);
            } catch (NoResultException e) {
                //CREATE
                entityManager.persist(pianificato);
            }
        });
    }
    @Override
    @Transactional
    public List<Pianificato> getPianificatoByIdDipendente(Long idDipendente) {
        return entityManager.createNamedQuery(PIANIFICATO_FIND_BY_ID_DIPENDENTE, Pianificato.class).setParameter(ID_DIPENDENTE, idDipendente).getResultList();
    }

    @Override
    @Transactional
    public boolean existsPianificatoById(Long id, String query, String parameter) {
        List<Pianificato> resultList = entityManager.createNamedQuery(query, Pianificato.class).setParameter(parameter, id).getResultList();
        return resultList != null && !resultList.isEmpty();
    }

    @Override
    @Transactional
    public PianificatoDTO getPianificatoByIdProgetto(Long idProgetto) {
        PianificatoDTO result = new PianificatoDTO();
        List<Pianificato> pianificatoList = entityManager.createNamedQuery(PIANIFICATO_FIND_BY_ID_PROGETTO, Pianificato.class).setParameter(ID_PROGETTO, idProgetto).getResultList();
        if(pianificatoList.isEmpty()){
            result.setIdProgetto(idProgetto);
            result.setPianificatoDipendenteDTOList(new ArrayList<>());
            result.setNote("");
            return result;
        }
        List<PianificatoDipendenteDTO> list = new ArrayList<>();
       pianificatoList
                .stream()
                .collect(Collectors.groupingBy(p -> Pair.of(p.getProgetto().getId(), p.getDipendente().getId())))
                .values()
                .forEach(pair -> list.add(pianificatoMapper.fromEntityToDTO(pair)));
        result.setNote(pianificatoList.get(0).getNote());
        result.setIdProgetto(idProgetto);
        result.setPianificatoDipendenteDTOList(list);
        return result;
    }

}
