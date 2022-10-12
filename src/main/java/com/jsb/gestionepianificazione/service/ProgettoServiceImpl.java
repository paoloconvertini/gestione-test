package com.jsb.gestionepianificazione.service;

import com.jsb.gestionepianificazione.dto.ProgettoDTO;
import com.jsb.gestionepianificazione.entity.Progetto;
import com.jsb.gestionepianificazione.mapper.ProgettoMapper;
import com.jsb.gestionepianificazione.service.api.IProgettoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.List;

import static com.jsb.gestionepianificazione.constant.DatabaseConstant.PROGETTO_FIND_ALL;

@ApplicationScoped
public class ProgettoServiceImpl implements IProgettoService {

    @Inject
    EntityManager entityManager;

    @Inject
    ProgettoMapper progettoMapper;

    @Transactional
    @Override
    public void saveProgetto(ProgettoDTO progetto) {
        Progetto entity = progettoMapper.fromDTOtoEntity(progetto);
        entityManager.persist(entity);
    }

    @Override
    public Progetto getProgetto(Long id) {
        Progetto entity = entityManager.find(Progetto.class, id);
        if (entity == null) {
            throw new WebApplicationException("Il progetto con id " + id + " non esiste.", 404);
        }
        return entity;
    }

    @Override
    @Transactional
    public void deleteProgetto(Long id) {
        Progetto progetto = entityManager.getReference(Progetto.class, id);
        if (progetto == null) {
            throw new WebApplicationException("Il progetto con id " + id + " non esiste.", 404);
        }
        entityManager.remove(progetto);
    }

    public List<Progetto> getProgetti() {
        return entityManager.createNamedQuery(PROGETTO_FIND_ALL, Progetto.class).getResultList();
    }

    @Override
    @Transactional
    public void updateProgetto(Long id, Progetto progetto) {
        if (progetto.getNome() == null) {
            throw new WebApplicationException("Il nome del progetto non è stato impostato.", 422);
        }

        Progetto entity = entityManager.find(Progetto.class, id);
        if (entity == null) {
            throw new WebApplicationException("Il progetto con id " + id + " non esiste.", 404);
        }
        entity.setNome(progetto.getNome());
    }

}
