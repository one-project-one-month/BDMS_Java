package com.opom.bdms.features.bloodRequest.dto.response;

import com.opom.bdms.dto.response.MasterData;
import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodRequestStatus;
import com.opom.bdms.enums.Urgency;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record BloodRequestResponse(
        Long id,
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
        Long hospitalId,
        MasterData masterData
) {
}
