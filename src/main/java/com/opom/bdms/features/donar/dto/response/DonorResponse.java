package com.opom.bdms.features.donar.dto.response;

import com.opom.bdms.dto.response.MasterData;
import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.Gender;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record DonorResponse(
        Long id,
        String nrc_no,
        LocalDate date_of_birth,
        Long user_id,
        Gender gender,
        BloodGroup bloodGroup,
        BigDecimal weight,
        LocalDate lastDonationDate,
        String remarks,
        String emergencyContact,
        String emergencyPhone,
        String address,
        MasterData masterData) {
}
