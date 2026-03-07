package com.opom.bdms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing screening status values.
 */
@Getter
@RequiredArgsConstructor
public enum ScreeningStatus implements BaseEnum {
    PENDING(1, "Pending"),
    FAILED(2, "Failed"),
    PASSED(3, "Passed");

    private final Integer value;
    private final String description;
}
