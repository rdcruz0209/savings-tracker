package com.rdcruz.savingstracker.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum TransactionCategoryEnum {

    HOUSE_FUND("House Funds"),
    CAR_FUND("Car Funds"),
    WEDDING_FUND("Wedding Funds"),
    TRAVEL_FUND("Travel Funds"),
    FAMILY_FUND("Family Funds");

    private final String name;

    TransactionCategoryEnum(String name) {
        this.name = name;
    }
}
