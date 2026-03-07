package com.opom.bdms.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Base converter for converting enums to integers in the database.
 * This converter handles the conversion between enum values and their integer representations.
 *
 * @param <E> The enum type that implements BaseEnum
 */
@Converter
public abstract class BaseEnumConverter<E extends Enum<E> & BaseEnum> implements AttributeConverter<E, Integer> {

    private final Class<E> enumClass;

    protected BaseEnumConverter(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public Integer convertToDatabaseColumn(E attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public E convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        for (E enumValue : enumClass.getEnumConstants()) {
            if (enumValue.getValue().equals(dbData)) {
                return enumValue;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + dbData);
    }
}
