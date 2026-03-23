package com.opom.bdms.features.appointment.dto.response;

import com.opom.bdms.dto.response.MasterData;
import com.opom.bdms.enums.AppointmentStatus;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record AppointmentResponse(
        Long id,
        Long userId,
        Long hospitalId,
        Long donationId,
        Long bloodRequestId,
        LocalDate appointmentDate,
        LocalTime appointmentTime,
        AppointmentStatus appointmentStatus,
        String remarks,
        MasterData masterData
) {
}
