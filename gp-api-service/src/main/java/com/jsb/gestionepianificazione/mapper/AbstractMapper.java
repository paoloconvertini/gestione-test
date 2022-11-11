package com.jsb.gestionepianificazione.mapper;

import com.jsb.gestionepianificazione.dto.MeseDTO;

public abstract class AbstractMapper {

    protected MeseDTO creaMese(Double gennaio,
                               Double febbraio,
                               Double marzo,
                               Double aprile,
                               Double maggio,
                               Double giugno,
                               Double luglio,
                               Double agosto,
                               Double settembre,
                               Double ottobre,
                               Double novembre,
                               Double dicembre) {
        MeseDTO mese = new MeseDTO();
        mese.setGennaio(gennaio);
        mese.setFebbraio(febbraio);
        mese.setMarzo(marzo);
        mese.setAprile(aprile);
        mese.setMaggio(maggio);
        mese.setGiugno(giugno);
        mese.setLuglio(luglio);
        mese.setAgosto(agosto);
        mese.setSettembre(settembre);
        mese.setOttobre(ottobre);
        mese.setNovembre(novembre);
        mese.setDicembre(dicembre);
        return mese;
    }
}
