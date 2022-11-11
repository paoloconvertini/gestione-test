package com.jsb.gestionepianificazione.mapper;

import com.jsb.gestionepianificazione.dto.MeseDTO;
import com.jsb.gestionepianificazione.dto.PianificatoDTO;
import com.jsb.gestionepianificazione.dto.PianificatoDipendenteDTO;
import com.jsb.gestionepianificazione.entity.Dipendente;
import com.jsb.gestionepianificazione.entity.Pianificato;
import com.jsb.gestionepianificazione.service.DipendenteServiceImpl;
import com.jsb.gestionepianificazione.service.ProgettoServiceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PianificatoMapper extends AbstractMapper {

    @Inject
    DipendenteServiceImpl dipendenteService;

    @Inject
    ProgettoServiceImpl progettoService;

    public PianificatoDipendenteDTO fromEntityToDTO(List<Pianificato> pianificati) {
        PianificatoDipendenteDTO dto = new PianificatoDipendenteDTO();
        pianificati.forEach(p -> {
            if(p.getFlagProgrammato()){
                dto.setProgrammato(creaMese(p));
            } else {
                dto.setFatturato(creaMese(p));
            }
        });
        dto.setIdDipendente(pianificati.get(0).getDipendente().getId());
        Dipendente dipendente = this.dipendenteService.getDipendente(dto.getIdDipendente());
        dto.setNomeDipendente(dipendente.getNome() + " " + dipendente.getCognome());
        return dto;
    }

    public List<Pianificato> fromDTOtoEntity(PianificatoDTO pianificatoDTO) {
        List<Pianificato> result = new ArrayList<>();
        pianificatoDTO.getPianificatoDipendenteDTOList().forEach(p -> {
                    result.add(creaPianificato(pianificatoDTO, p, false));
                    result.add(creaPianificato(pianificatoDTO, p, true));
                }
        );
        return result;
    }

    private Pianificato creaPianificato(PianificatoDTO pianificatoDTO, PianificatoDipendenteDTO p, boolean programmato) {
        Pianificato pianificato = new Pianificato();
        pianificato.setProgetto(progettoService.getProgetto(pianificatoDTO.getIdProgetto()));
        pianificato.setNote(pianificatoDTO.getNote());
        pianificato.setDipendente(dipendenteService.getDipendente(p.getIdDipendente()));
        pianificato.setFlagProgrammato(programmato);
        if(programmato) {
            setProgrammato(pianificato, p.getProgrammato());
        } else {
            setProgrammato(pianificato, p.getFatturato());
        }
        return pianificato;
    }

    private void setProgrammato(Pianificato pianificato, MeseDTO mese) {
        creaPianificato(pianificato, mese.getGennaio(), mese.getFebbraio(), mese.getMarzo(), mese.getAprile(), mese.getMaggio(), mese.getGiugno(), mese.getLuglio(), mese.getAgosto(), mese.getSettembre(), mese.getOttobre(), mese.getNovembre(), mese.getDicembre());
    }

    private void creaPianificato(Pianificato pianificato, Double gennaio, Double febbraio, Double marzo, Double aprile, Double maggio, Double giugno, Double luglio, Double agosto, Double settembre, Double ottobre, Double novembre, Double dicembre) {
        pianificato.setGennaio(gennaio);
        pianificato.setFebbraio(febbraio);
        pianificato.setMarzo(marzo);
        pianificato.setAprile(aprile);
        pianificato.setMaggio(maggio);
        pianificato.setGiugno(giugno);
        pianificato.setLuglio(luglio);
        pianificato.setAgosto(agosto);
        pianificato.setSettembre(settembre);
        pianificato.setOttobre(ottobre);
        pianificato.setNovembre(novembre);
        pianificato.setDicembre(dicembre);
    }

    public void updateEntity(Pianificato pianificatoDaSalvare, Pianificato pianificato) {
        creaPianificato(pianificatoDaSalvare, pianificato.getGennaio(), pianificato.getFebbraio(), pianificato.getMarzo(), pianificato.getAprile(), pianificato.getMaggio(), pianificato.getGiugno(), pianificato.getLuglio(), pianificato.getAgosto(), pianificato.getSettembre(), pianificato.getOttobre(), pianificato.getNovembre(), pianificato.getDicembre());
        pianificatoDaSalvare.setDipendente(pianificato.getDipendente());
        pianificatoDaSalvare.setProgetto(pianificato.getProgetto());
        pianificatoDaSalvare.setFlagProgrammato(pianificato.getFlagProgrammato());
        pianificatoDaSalvare.setNote(pianificato.getNote());
    }

    private MeseDTO creaMese(Pianificato pianificato) {
        return super.creaMese(pianificato.getGennaio(), pianificato.getFebbraio(), pianificato.getMarzo(), pianificato.getAprile(), pianificato.getMaggio(), pianificato.getGiugno(), pianificato.getLuglio(), pianificato.getAgosto(), pianificato.getSettembre(), pianificato.getOttobre(), pianificato.getNovembre(), pianificato.getDicembre());
    }

}
