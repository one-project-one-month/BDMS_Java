package com.opom.bdms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing status values for blood requests.
 */
@Getter
@RequiredArgsConstructor
public enum BloodRequestStatus implements BaseEnum {
    PENDING(1, "Pending"),
    CANCELLED(2, "Cancelled"),
    APPROVED(3, "Approved"),
    REJECTED(4, "Rejected"),
    FULFILLED(5, "Fulfilled");

    private final Integer value;
    private final String description;
}
