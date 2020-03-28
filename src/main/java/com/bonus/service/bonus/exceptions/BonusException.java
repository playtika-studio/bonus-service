package com.bonus.service.bonus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BonusException extends Exception {
    public BonusException(String s) {
        super(s);
    }
}
