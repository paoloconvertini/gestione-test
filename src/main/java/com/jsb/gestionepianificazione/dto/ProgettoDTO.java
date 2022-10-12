package com.jsb.gestionepianificazione.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProgettoDTO implements Serializable {
    private String nome;
}
