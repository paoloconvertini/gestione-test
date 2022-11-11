package com.jsb.gestionepianificazione.service.api;

import com.jsb.gestionepianificazione.dto.ProgettoDTO;
import com.jsb.gestionepianificazione.entity.Progetto;

import java.util.List;

public interface IProgettoService {

    List<Progetto> getProgetti();

    void saveProgetto(ProgettoDTO progetto);

    void updateProgetto(Long id, Progetto progetto);

    Progetto getProgetto(Long id);

    void deleteProgetto(Long id);


}
