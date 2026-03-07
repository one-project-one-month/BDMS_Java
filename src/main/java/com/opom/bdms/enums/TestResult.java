package com.opom.bdms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing test result values for medical screenings.
 */
@Getter
@RequiredArgsConstructor
public enum TestResult implements BaseEnum {
    POSITIVE(1, "Positive"),
    NEGATIVE(2, "Negative"),
    INCONCLUSIVE(3, "Inconclusive");

    private final Integer value;
    private final String description;
}
