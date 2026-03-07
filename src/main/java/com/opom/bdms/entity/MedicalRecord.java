package com.opom.bdms.entity;

import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodGroupConverter;
import com.opom.bdms.enums.ScreeningStatus;
import com.opom.bdms.enums.ScreeningStatusConverter;
import com.opom.bdms.enums.TestResult;
import com.opom.bdms.enums.TestResultConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity representing medical screening results for a donation.
 * Contains test results and screening status for blood donations.
 */
@Entity
@Table(name = "medical_records")
@Getter
@Setter
public class MedicalRecord extends MasterEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donation_id", nullable = false, unique = true)
    private Donation donation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @Column(name = "hemoglobin_level", precision = 4, scale = 2)
    private BigDecimal hemoglobinLevel;

    @Convert(converter = TestResultConverter.class)
    @Column(name = "hiv_result")
    private TestResult hivResult;

    @Convert(converter = TestResultConverter.class)
    @Column(name = "hepatitis_b_result")
    private TestResult hepatitisBResult;

    @Convert(converter = TestResultConverter.class)
    @Column(name = "hepatitis_c_result")
    private TestResult hepatitisCResult;

    @Convert(converter = TestResultConverter.class)
    @Column(name = "malaria_result")
    private TestResult malariaResult;

    @Convert(converter = TestResultConverter.class)
    @Column(name = "syphilis_result")
    private TestResult syphilisResult;

    @Convert(converter = BloodGroupConverter.class)
    @Column(name = "blood_group", nullable = false)
    private BloodGroup bloodGroup;

    @Convert(converter = ScreeningStatusConverter.class)
    @Column(name = "screening_status", nullable = false)
    private ScreeningStatus screeningStatus;

    @Column(name = "screening_notes", columnDefinition = "TEXT")
    private String screeningNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screened_by", nullable = false)
    private User screenedBy;

    @Column(name = "screening_at", nullable = false)
    private LocalDateTime screeningAt;
}
