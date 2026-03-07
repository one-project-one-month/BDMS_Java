package com.opom.bdms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing status values for blood inventory.
 */
@Getter
@RequiredArgsConstructor
public enum BloodInventoryStatus implements BaseEnum {
    AVAILABLE(1, "Available"),
    USED(2, "Used"),
    EXPIRED(3, "Expired");

    private final Integer value;
    private final String description;
}
