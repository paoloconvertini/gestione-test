package com.jsb.gestionepianificazione.service.api;

import com.jsb.gestionepianificazione.dto.DipendenteDTO;
import com.jsb.gestionepianificazione.entity.Dipendente;

import java.util.List;

public interface IDipendenteService {

    List<Dipendente> getDipendenti();

    void saveDipendente(DipendenteDTO dipendente);

    void updateDipendente(Dipendente dipendente);

    Dipendente getDipendente(Long id);

    void deleteDipendente(Long id);


}
