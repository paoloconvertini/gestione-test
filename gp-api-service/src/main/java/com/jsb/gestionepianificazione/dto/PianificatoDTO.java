package com.jsb.gestionepianificazione.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PianificatoDTO implements Serializable {
    private List<PianificatoDipendenteDTO> pianificatoDipendenteDTOList;
    private Long idProgetto;
    private String note;
}
