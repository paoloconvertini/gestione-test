package com.jsb.gestionepianificazione.dto;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @ToString @AllArgsConstructor
public class ResponseDTO implements Serializable {
    private String message;
    private boolean error;
}
