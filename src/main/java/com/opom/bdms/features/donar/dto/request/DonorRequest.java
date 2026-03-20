package com.opom.bdms.features.donar.dto.request;

import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DonorRequest(
                String nrc_no,

                LocalDate date_of_birth,

                Gender gender,

                Long user_id,

                BloodGroup bloodGroup,

                BigDecimal weight,

                LocalDate lastDonationDate,

                String remarks,

                String emergencyContact,

                String emergencyPhone,

                String address) {
}
