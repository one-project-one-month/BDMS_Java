package com.opom.bdms.entity;

import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodGroupConverter;
import com.opom.bdms.enums.DonationStatus;
import com.opom.bdms.enums.DonationStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entity representing a blood donation.
 * Tracks donations from donors and links to blood requests and inventories.
 */
@Entity
@Table(name = "donations")
@Getter
@Setter
public class Donation extends MasterEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donor_id", nullable = false)
    private Donor donor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blood_request_id")
    private BloodRequest bloodRequest;

    @Column(name = "donation_code", unique = true)
    private String donationCode;

    @Convert(converter = BloodGroupConverter.class)
    @Column(name = "blood_group", nullable = false)
    private BloodGroup bloodGroup;

    @Column(name = "units_donated")
    private Integer unitsDonated;

    @Column(name = "donation_date", nullable = false)
    private LocalDate donationDate;

    @Convert(converter = DonationStatusConverter.class)
    @Column(name = "status", nullable = false)
    private DonationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_by")
    private User approvedBy;

    @Column(name = "approved_at")
    private LocalDateTime approvedAt;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @OneToOne(mappedBy = "donation", cascade = CascadeType.ALL)
    private MedicalRecord medicalRecord;

    @OneToOne(mappedBy = "donation", cascade = CascadeType.ALL)
    private BloodInventory bloodInventory;


}
