package com.opom.bdms.enums;

/**
 * Base interface for all enums that need to be stored as integers in the database.
 * Enums implementing this interface must provide an integer value and description.
 */
public interface BaseEnum {
    Integer getValue();
    String getDescription();
}
