package com.jsb.gestionepianificazione.mapper;

import com.jsb.gestionepianificazione.dto.DipendenteDTO;
import com.jsb.gestionepianificazione.entity.Dipendente;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DipendenteMapper {

    public DipendenteDTO fromEntityToDTO(Dipendente dipendente){
        DipendenteDTO dipendenteDTO = new DipendenteDTO();
        dipendenteDTO.setNome(dipendente.getNome());
        dipendenteDTO.setCognome(dipendente.getCognome());
        return dipendenteDTO;
    }
    public Dipendente fromDTOtoEntity(DipendenteDTO dipendenteDTO){
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDTO.getNome());
        dipendente.setCognome(dipendenteDTO.getCognome());
        return dipendente;
    }

}
