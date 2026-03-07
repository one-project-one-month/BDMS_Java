package com.opom.bdms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing status values for appointments.
 */
@Getter
@RequiredArgsConstructor
public enum AppointmentStatus implements BaseEnum {
    SCHEDULED(1, "Scheduled"),
    CONFIRMED(2, "Confirmed"),
    CANCELLED(3, "Cancelled"),
    COMPLETED(4, "Completed");

    private final Integer value;
    private final String description;
}
