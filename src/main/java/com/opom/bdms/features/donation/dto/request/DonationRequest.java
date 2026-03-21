package com.opom.bdms.features.donation.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DonationRequest(

        Long donorId,
        Long hospitalId,
        Long bloodRequestId,
        String bloodGroup,
        Integer unitsDonated,
        LocalDate donationDate,
        String remarks) {
}