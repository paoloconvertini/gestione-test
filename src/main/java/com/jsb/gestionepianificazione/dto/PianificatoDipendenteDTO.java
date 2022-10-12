package com.jsb.gestionepianificazione.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @EqualsAndHashCode @ToString
public class PianificatoDipendenteDTO implements Serializable {
    private Long idDipendente;
    private String nomeDipendente;
    MeseDTO programmato;
    MeseDTO fatturato;
}

