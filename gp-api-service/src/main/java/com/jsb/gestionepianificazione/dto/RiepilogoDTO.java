package com.jsb.gestionepianificazione.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RiepilogoDTO implements Serializable {

    private String dipendente;
    private String progetti;
    MeseDTO programmato;
    Double pianificato;
}
