package com.opom.bdms.enums;

import jakarta.persistence.Converter;

/**
 * Converter for BloodGroup enum to Integer.
 */
@Converter(autoApply = true)
public class BloodGroupConverter extends BaseEnumConverter<BloodGroup> {
    public BloodGroupConverter() {
        super(BloodGroup.class);
    }
}
