package com.opom.bdms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entity representing a hospital in the system.
 * Hospitals can be associated with users, blood requests, appointments, donations, and inventories.
 */
@Entity
@Table(name = "hospitals")
@Getter
@Setter
public class Hospital extends MasterEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "is_verified")
    private Boolean isVerified = false;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<BloodRequest> bloodRequests;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Donation> donations;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<MedicalRecord> medicalRecords;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<BloodInventory> bloodInventories;
}
