package com.opom.bdms.enums;

import jakarta.persistence.Converter;

/**
 * Converter for BloodRequestStatus enum to Integer.
 */
@Converter(autoApply = true)
public class BloodRequestStatusConverter extends BaseEnumConverter<BloodRequestStatus> {
    public BloodRequestStatusConverter() {
        super(BloodRequestStatus.class);
    }
}
