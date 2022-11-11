package com.jsb.gestionepianificazione.mapper;

import com.jsb.gestionepianificazione.dto.MeseDTO;
import com.jsb.gestionepianificazione.dto.RiepilogoDTO;
import com.jsb.gestionepianificazione.dto.RiepilogoResultSet;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RiepilogoMapper extends AbstractMapper {

    public RiepilogoDTO fromEntityToDTO(List<RiepilogoResultSet> resultSetList){
        RiepilogoDTO riepilogoDTO = new RiepilogoDTO();
        resultSetList.forEach(rs -> {
            if(StringUtils.isBlank(riepilogoDTO.getDipendente())){
                riepilogoDTO.setDipendente(rs.getDipendente());
            }
            if(StringUtils.isBlank(riepilogoDTO.getProgetti())){
                riepilogoDTO.setProgetti(rs.getProgetti());
            }
            riepilogoDTO.setProgrammato(creaMese(rs));
            riepilogoDTO.setPianificato(rs.getPianificato());
        });
        return riepilogoDTO;
    }

    private MeseDTO creaMese(RiepilogoResultSet rs) {
        return super.creaMese(rs.getGennaio(), rs.getFebbraio(), rs.getMarzo(), rs.getAprile(), rs.getMaggio(), rs.getGiugno(), rs.getLuglio(), rs.getAgosto(), rs.getSettembre(), rs.getOttobre(), rs.getNovembre(), rs.getDicembre());
    }

}
