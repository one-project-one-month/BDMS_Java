package com.opom.bdms.enums;

import jakarta.persistence.Converter;

/**
 * Converter for ScreeningStatus enum to Integer.
 */
@Converter(autoApply = true)
public class ScreeningStatusConverter extends BaseEnumConverter<ScreeningStatus> {
    public ScreeningStatusConverter() {
        super(ScreeningStatus.class);
    }
}
