package com.opom.bdms.enums;

import jakarta.persistence.Converter;

/**
 * Converter for Gender enum to Integer.
 */
@Converter(autoApply = true)
public class GenderConverter extends BaseEnumConverter<Gender> {
    public GenderConverter() {
        super(Gender.class);
    }
}
