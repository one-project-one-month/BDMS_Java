package com.opom.bdms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing gender options.
 */
@Getter
@RequiredArgsConstructor
public enum Gender implements BaseEnum {
    MALE(1, "Male"),
    FEMALE(2, "Female"),
    OTHER(3, "Other");

    private final Integer value;
    private final String description;
}
