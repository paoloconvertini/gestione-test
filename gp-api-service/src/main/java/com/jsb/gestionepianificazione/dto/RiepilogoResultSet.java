package com.jsb.gestionepianificazione.dto;

import lombok.*;

import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RiepilogoResultSet implements Serializable {

    private String dipendente;
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
    private String progetti;
    private Double pianificato;
}
