package com.opom.bdms.features.bloodRequest.dto.request;

import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodRequestStatus;
import com.opom.bdms.enums.Urgency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record BloodRequestRequest(

        @NotBlank(message = "Blood Request Code is required")
        String bloodRequestCode,
        String patientName,
        BloodGroup bloodGroup,
        Integer unitsRequired,
        String contactPhone,
        Urgency urgency,
        LocalDate requiredDate,
        BloodRequestStatus status,
        String reason,
        LocalDateTime approvedAt,
        Long userId,
        Long hospitalId
) {}
