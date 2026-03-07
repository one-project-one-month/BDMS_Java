package com.opom.bdms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing blood group types.
 */
@Getter
@RequiredArgsConstructor
public enum BloodGroup implements BaseEnum {
    A_POSITIVE(1, "A+"),
    A_NEGATIVE(2, "A-"),
    B_POSITIVE(3, "B+"),
    B_NEGATIVE(4, "B-"),
    AB_POSITIVE(5, "AB+"),
    AB_NEGATIVE(6, "AB-"),
    O_POSITIVE(7, "O+"),
    O_NEGATIVE(8, "O-");

    private final Integer value;
    private final String description;
}
