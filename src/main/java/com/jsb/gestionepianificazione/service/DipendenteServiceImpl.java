package com.jsb.gestionepianificazione.service;

import com.jsb.gestionepianificazione.dto.DipendenteDTO;
import com.jsb.gestionepianificazione.entity.Dipendente;
import com.jsb.gestionepianificazione.mapper.DipendenteMapper;
import com.jsb.gestionepianificazione.service.api.IDipendenteService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.List;

import static com.jsb.gestionepianificazione.constant.DatabaseConstant.DIPENDENTE_FIND_ALL;

@ApplicationScoped
public class DipendenteServiceImpl implements IDipendenteService {

    @Inject
    EntityManager entityManager;

    @Inject
    DipendenteMapper dipendenteMapper;

    @Transactional
    @Override
    public void saveDipendente(DipendenteDTO dipendente) {
        Dipendente entity = dipendenteMapper.fromDTOtoEntity(dipendente);
        entityManager.persist(entity);
    }

    @Override
    public Dipendente getDipendente(Long id) {
        Dipendente entity = entityManager.find(Dipendente.class, id);
        if (entity == null) {
            throw new WebApplicationException("Il dipendente con id " + id + " non esiste.", 404);
        }
        return entity;
    }

    @Override
    @Transactional
    public void deleteDipendente(Long id) {
        Dipendente dipendente = entityManager.getReference(Dipendente.class, id);
        if (dipendente == null) {
            throw new WebApplicationException("Il dipendente con id " + id + " non esiste.", 404);
        }
        entityManager.remove(dipendente);
    }

    public List<Dipendente> getDipendenti() {
        return entityManager.createNamedQuery(DIPENDENTE_FIND_ALL, Dipendente.class).getResultList();
    }

    @Override
    @Transactional
    public void updateDipendente(Long id, Dipendente dipendente) {
        if (dipendente.getNome() == null) {
            throw new WebApplicationException("Il nome del dipendente non è stato impostato.", 422);
        }
        if (dipendente.getCognome() == null) {
            throw new WebApplicationException("Il cognome del dipendente non è stato impostato.", 422);
        }

        Dipendente entity = entityManager.find(Dipendente.class, id);
        if (entity == null) {
            throw new WebApplicationException("Il dipendente con id " + id + " non esiste.", 404);
        }
        entity.setNome(dipendente.getNome());
        entity.setCognome(dipendente.getCognome());
    }

}
