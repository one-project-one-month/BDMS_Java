package com.opom.bdms.enums;

import jakarta.persistence.Converter;

/**
 * Converter for DonationStatus enum to Integer.
 */
@Converter(autoApply = true)
public class DonationStatusConverter extends BaseEnumConverter<DonationStatus> {
    public DonationStatusConverter() {
        super(DonationStatus.class);
    }
}
