package com.super13.accountservice.domain;

public enum Currency {

    USD, EUR, RUB;

    public static Currency getDefault() {
        return USD;
    }
}
