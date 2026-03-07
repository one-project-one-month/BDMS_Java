package com.opom.bdms.entity;

import com.opom.bdms.enums.AppointmentStatus;
import com.opom.bdms.enums.AppointmentStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Entity representing an appointment for blood donation or blood request.
 * Links users, hospitals, donations, and blood requests.
 */
@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment extends MasterEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donation_id")
    private Donation donation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blood_request_id")
    private BloodRequest bloodRequest;

    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @Column(name = "appointment_time", nullable = false)
    private LocalTime appointmentTime;

    @Convert(converter = AppointmentStatusConverter.class)
    @Column(name = "status", nullable = false)
    private AppointmentStatus status;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;
}
