package com.opom.bdms.entity;

import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodGroupConverter;
import com.opom.bdms.enums.BloodInventoryStatus;
import com.opom.bdms.enums.BloodInventoryStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Entity representing blood inventory in the system.
 * Tracks available blood units and their expiration dates.
 */
@Entity
@Table(name = "blood_inventories")
@Getter
@Setter
public class BloodInventory extends MasterEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donation_id", nullable = false, unique = true)
    private Donation donation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @Convert(converter = BloodGroupConverter.class)
    @Column(name = "blood_group", nullable = false)
    private BloodGroup bloodGroup;

    @Column(name = "units", nullable = false)
    private Integer units;

    @Column(name = "collected_at", nullable = false)
    private LocalDate collectedAt;

    @Column(name = "expired_at", nullable = false)
    private LocalDate expiredAt;

    @Convert(converter = BloodInventoryStatusConverter.class)
    @Column(name = "status", nullable = false)
    private BloodInventoryStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blood_request_id")
    private BloodRequest bloodRequest;
}
