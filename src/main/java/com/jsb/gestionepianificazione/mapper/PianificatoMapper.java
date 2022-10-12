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
public class PianificatoMapper {

    @Inject
    DipendenteServiceImpl dipendenteService;

    @Inject
    ProgettoServiceImpl progettoService;

    public PianificatoDipendenteDTO fromEntityToDTO(List<Pianificato> pianificato) {
        PianificatoDipendenteDTO dto = new PianificatoDipendenteDTO();
        pianificato.forEach(p -> {
            if(p.getFlagProgrammato()){
                dto.setProgrammato(creaMese(p));
            } else {
                dto.setFatturato(creaMese(p));
            }
        });
        dto.setIdDipendente(pianificato.get(0).getDipendente().getId());
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
        pianificato.setGennaio(mese.getGennaio());
        pianificato.setFebbraio(mese.getFebbraio());
        pianificato.setMarzo(mese.getMarzo());
        pianificato.setAprile(mese.getAprile());
        pianificato.setMaggio(mese.getMaggio());
        pianificato.setGiugno(mese.getGiugno());
        pianificato.setLuglio(mese.getLuglio());
        pianificato.setAgosto(mese.getAgosto());
        pianificato.setSettembre(mese.getSettembre());
        pianificato.setOttobre(mese.getOttobre());
        pianificato.setNovembre(mese.getNovembre());
        pianificato.setDicembre(mese.getDicembre());
    }

    public void updateEntity(Pianificato pianificatoDaSalvare, Pianificato pianificato) {
        pianificatoDaSalvare.setGennaio(pianificato.getGennaio());
        pianificatoDaSalvare.setFebbraio(pianificato.getFebbraio());
        pianificatoDaSalvare.setMarzo(pianificato.getMarzo());
        pianificatoDaSalvare.setAprile(pianificato.getAprile());
        pianificatoDaSalvare.setMaggio(pianificato.getMaggio());
        pianificatoDaSalvare.setGiugno(pianificato.getGiugno());
        pianificatoDaSalvare.setLuglio(pianificato.getLuglio());
        pianificatoDaSalvare.setAgosto(pianificato.getAgosto());
        pianificatoDaSalvare.setSettembre(pianificato.getSettembre());
        pianificatoDaSalvare.setOttobre(pianificato.getOttobre());
        pianificatoDaSalvare.setNovembre(pianificato.getNovembre());
        pianificatoDaSalvare.setDicembre(pianificato.getDicembre());
        pianificatoDaSalvare.setDipendente(pianificato.getDipendente());
        pianificatoDaSalvare.setProgetto(pianificato.getProgetto());
        pianificatoDaSalvare.setFlagProgrammato(pianificato.getFlagProgrammato());
        pianificatoDaSalvare.setNote(pianificato.getNote());
    }

    private MeseDTO creaMese(Pianificato pianificato) {
        MeseDTO mese = new MeseDTO();
        mese.setGennaio(pianificato.getGennaio());
        mese.setFebbraio(pianificato.getFebbraio());
        mese.setMarzo(pianificato.getMarzo());
        mese.setAprile(pianificato.getAprile());
        mese.setMaggio(pianificato.getMaggio());
        mese.setGiugno(pianificato.getGiugno());
        mese.setLuglio(pianificato.getLuglio());
        mese.setAgosto(pianificato.getAgosto());
        mese.setSettembre(pianificato.getSettembre());
        mese.setOttobre(pianificato.getOttobre());
        mese.setNovembre(pianificato.getNovembre());
        mese.setDicembre(pianificato.getDicembre());
        return mese;
    }

}
