package com.ibk.ibkchallenge.infrastructure.exception.custom;

import com.ibk.ibkchallenge.infrastructure.exception.UnrecoverableException;
import lombok.Getter;

import static com.ibk.ibkchallenge.infrastructure.exception.enums.CommonEnumException.NOT_FOUND_ERROR;

@Getter
public class NotFoundException extends UnrecoverableException {

    public NotFoundException() {
        super(NOT_FOUND_ERROR.errorCode, NOT_FOUND_ERROR.errorDescription);
    }
}
