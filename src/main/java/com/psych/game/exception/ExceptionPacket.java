package com.psych.game.exception;

import lombok.Getter;
import lombok.Setter;

public class ExceptionPacket {

    @Getter @Setter
    private String message;
    @Getter @Setter
    private int code;

    public ExceptionPacket(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
