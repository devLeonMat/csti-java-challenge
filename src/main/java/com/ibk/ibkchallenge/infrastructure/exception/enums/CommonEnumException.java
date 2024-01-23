package com.ibk.ibkchallenge.infrastructure.exception.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CommonEnumException {

    NOT_FOUND_ERROR("IBK-101", "The request resource does not exists."),
    ALREADY_EXISTS_ERROR("IBK-102", "The request resource does already exists.");

    public final String errorCode;
    public final String errorDescription;


}
