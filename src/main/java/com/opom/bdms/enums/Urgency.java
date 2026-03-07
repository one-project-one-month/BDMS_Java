package com.opom.bdms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing urgency levels for blood requests.
 */
@Getter
@RequiredArgsConstructor
public enum Urgency implements BaseEnum {
    LOW(1, "Low"),
    MEDIUM(2, "Medium"),
    HIGH(3, "High"),
    CRITICAL(4, "Critical");

    private final Integer value;
    private final String description;
}
