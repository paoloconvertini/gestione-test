package com.jsb.gestionepianificazione.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @EqualsAndHashCode @ToString
public class MeseDTO implements Serializable {
    private Double gennaio;
    private Double febbraio;
    private Double marzo;
    private Double aprile;
    private Double maggio;
    private Double giugno;
    private Double luglio;
    private Double agosto;
    private Double settembre;
    private Double ottobre;
    private Double novembre;
    private Double dicembre;
}
