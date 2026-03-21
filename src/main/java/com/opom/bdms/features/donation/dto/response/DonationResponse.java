package com.opom.bdms.features.donation.dto.response;

import com.opom.bdms.dto.response.MasterData;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record DonationResponse(
        Long id,
        Long donorId,
        Long hospitalId,
        Long bloodRequestId,
        String bloodGroup,
        Integer unitsDonated,
        LocalDate donationDate,
        String remarks,
        MasterData masterData
) {}