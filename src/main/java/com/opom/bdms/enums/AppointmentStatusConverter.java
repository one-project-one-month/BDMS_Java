package com.opom.bdms.enums;

import jakarta.persistence.Converter;

/**
 * Converter for AppointmentStatus enum to Integer.
 */
@Converter(autoApply = true)
public class AppointmentStatusConverter extends BaseEnumConverter<AppointmentStatus> {
    public AppointmentStatusConverter() {
        super(AppointmentStatus.class);
    }
}
