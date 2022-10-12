package com.jsb.gestionepianificazione.service.api;

import com.jsb.gestionepianificazione.dto.PianificatoDTO;
import com.jsb.gestionepianificazione.entity.Pianificato;

import java.util.List;

public interface IPianificatoService {

    PianificatoDTO getPianificatoByIdProgetto(Long id);

    void savePianificato(PianificatoDTO pianificatoDTO);

    Pianificato getPianificato(Long id);

    void deletePianificato(Long id);


}
