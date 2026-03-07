package com.opom.bdms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing status values for donations.
 */
@Getter
@RequiredArgsConstructor
public enum DonationStatus implements BaseEnum {
    PENDING(1, "Pending"),
    CANCELLED(2, "Cancelled"),
    APPROVED(3, "Approved"),
    SCREENING(4, "Screening"),
    REJECTED(5, "Rejected"),
    COMPLETED(6, "Completed");

    private final Integer value;
    private final String description;
}
