package com.opom.bdms.features.donation.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DonationFilter {

    private Long donorId;
    private Long hospitalId;
    private Long bloodRequestId;
    private String bloodGroup;
    private Integer unitsDonated;
    private LocalDate donationDate;
    private String remarks;
}
