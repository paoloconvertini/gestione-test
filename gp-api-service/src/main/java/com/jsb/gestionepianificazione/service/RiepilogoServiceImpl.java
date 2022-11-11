package com.jsb.gestionepianificazione.service;

import com.jsb.gestionepianificazione.dto.RiepilogoDTO;
import com.jsb.gestionepianificazione.dto.RiepilogoResultSet;
import com.jsb.gestionepianificazione.mapper.RiepilogoMapper;
import com.jsb.gestionepianificazione.service.api.IRiepilogoService;
import org.apache.commons.lang3.tuple.Pair;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.jsb.gestionepianificazione.constant.DatabaseConstant.RIEPILOGO_QUERY;

@ApplicationScoped
public class RiepilogoServiceImpl implements IRiepilogoService {

    @Inject
    EntityManager entityManager;

    @Inject
    RiepilogoMapper mapper;

    @Override
    @Transactional
    public List<RiepilogoDTO> getRiepilogo() {
        List<RiepilogoDTO> result = new ArrayList<>();
        List<RiepilogoResultSet> resultList = entityManager.createNativeQuery(RIEPILOGO_QUERY, "RiepilogoMapping").getResultList();
        resultList.stream()
                .collect(Collectors.groupingBy(p -> Pair.of(p.getDipendente(), p.getProgetti())))
                .values()
                .forEach(pair -> result.add(mapper.fromEntityToDTO(pair)));
        return result;
    }

}
