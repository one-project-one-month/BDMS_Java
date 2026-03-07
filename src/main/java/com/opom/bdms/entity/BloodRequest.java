package com.opom.bdms.entity;

import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodGroupConverter;
import com.opom.bdms.enums.BloodRequestStatus;
import com.opom.bdms.enums.BloodRequestStatusConverter;
import com.opom.bdms.enums.Urgency;
import com.opom.bdms.enums.UrgencyConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity representing a blood request from a hospital or patient.
 * Tracks the status and fulfillment of blood requests.
 */
@Entity
@Table(name = "blood_requests")
@Getter
@Setter
public class BloodRequest extends MasterEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @Column(name = "blood_request_code", unique = true)
    private String bloodRequestCode;

    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Convert(converter = BloodGroupConverter.class)
    @Column(name = "blood_group", nullable = false)
    private BloodGroup bloodGroup;

    @Column(name = "units_required", nullable = false)
    private Integer unitsRequired;

    @Column(name = "contact_phone", nullable = false)
    private String contactPhone;

    @Convert(converter = UrgencyConverter.class)
    @Column(name = "urgency", nullable = false)
    private Urgency urgency;

    @Column(name = "required_date", nullable = false)
    private LocalDate requiredDate;

    @Convert(converter = BloodRequestStatusConverter.class)
    @Column(name = "status", nullable = false)
    private BloodRequestStatus status;

    @Column(name = "reason", columnDefinition = "TEXT")
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_by")
    private User approvedBy;

    @Column(name = "approved_at")
    private LocalDateTime approvedAt;

    @OneToMany(mappedBy = "bloodRequest", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "bloodRequest", cascade = CascadeType.ALL)
    private List<Donation> donations;

    @OneToMany(mappedBy = "bloodRequest", cascade = CascadeType.ALL)
    private List<BloodInventory> bloodInventories;
}
