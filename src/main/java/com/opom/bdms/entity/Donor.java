package com.opom.bdms.entity;

import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodGroupConverter;
import com.opom.bdms.enums.Gender;
import com.opom.bdms.enums.GenderConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Entity representing a blood donor.
 * Contains detailed information about donors including medical and contact information.
 */
@Entity
@Table(name = "donors")
@Getter
@Setter
public class Donor extends MasterEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "nrc_no", nullable = false, unique = true)
    private String nrcNo;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Convert(converter = GenderConverter.class)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Convert(converter = BloodGroupConverter.class)
    @Column(name = "blood_group", nullable = false)
    private BloodGroup bloodGroup;

    @Column(name = "weight", precision = 5, scale = 2)
    private BigDecimal weight;

    @Column(name = "last_donation_date")
    private LocalDate lastDonationDate;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @Column(name = "emergency_phone")
    private String emergencyPhone;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    private List<Donation> donations;
}
