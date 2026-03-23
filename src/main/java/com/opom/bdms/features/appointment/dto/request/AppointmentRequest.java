package com.opom.bdms.features.appointment.dto.request;

import com.opom.bdms.enums.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentRequest (
        Long userId,
        Long hospitalId,
        Long donationId,
        Long bloodRequestId,
        LocalDate appointmentDate,
        LocalTime appointmentTime,
        AppointmentStatus appointmentStatus,
        String remarks
){}
