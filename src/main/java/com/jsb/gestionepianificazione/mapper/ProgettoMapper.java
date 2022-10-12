package com.jsb.gestionepianificazione.mapper;

import com.jsb.gestionepianificazione.dto.ProgettoDTO;
import com.jsb.gestionepianificazione.entity.Progetto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProgettoMapper {

    public ProgettoDTO fromEntityToDTO(Progetto progetto){
        ProgettoDTO progettoDTO = new ProgettoDTO();
        progettoDTO.setNome(progetto.getNome());
        return progettoDTO;
    }
    public Progetto fromDTOtoEntity(ProgettoDTO progettoDTO){
        Progetto progetto = new Progetto();
        progetto.setNome(progettoDTO.getNome());
        return progetto;
    }

}
