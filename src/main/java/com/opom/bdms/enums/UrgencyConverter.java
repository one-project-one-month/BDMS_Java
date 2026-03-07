package com.opom.bdms.enums;

import jakarta.persistence.Converter;

/**
 * Converter for Urgency enum to Integer.
 */
@Converter(autoApply = true)
public class UrgencyConverter extends BaseEnumConverter<Urgency> {
    public UrgencyConverter() {
        super(Urgency.class);
    }
}
