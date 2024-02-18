package com.rdcruz.savingstracker.domain.enums;

import lombok.Getter;

@Getter
public enum TypeEnum {
    DEBIT("Debit Type"),
    CREDIT("Credit Type"),
    REVERSAL("Reversal of Credit or Debit");

    private final String description;

    TypeEnum(String description) {
        this.description = description;
    }

}
