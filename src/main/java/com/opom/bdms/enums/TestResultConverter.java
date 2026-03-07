package com.opom.bdms.enums;

import jakarta.persistence.Converter;

/**
 * Converter for TestResult enum to Integer.
 */
@Converter(autoApply = true)
public class TestResultConverter extends BaseEnumConverter<TestResult> {
    public TestResultConverter() {
        super(TestResult.class);
    }
}
