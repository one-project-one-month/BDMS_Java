package com.opom.bdms.enums;

import jakarta.persistence.Converter;

/**
 * Converter for BloodInventoryStatus enum to Integer.
 */
@Converter(autoApply = true)
public class BloodInventoryStatusConverter extends BaseEnumConverter<BloodInventoryStatus> {
    public BloodInventoryStatusConverter() {
        super(BloodInventoryStatus.class);
    }
}
