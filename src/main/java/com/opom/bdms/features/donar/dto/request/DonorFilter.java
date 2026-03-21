package com.opom.bdms.features.donar.dto.request;

import com.opom.bdms.dto.request.BaseFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class DonorFilter extends BaseFilter {
    private String nrc_no;
    private Long user_id;
    private Gender gender;
    private BloodGroup bloodGroup;
    private BigDecimal weight;
    private LocalDate lastDonationDate;
    private LocalDate date_of_birth;
    private String remarks;
    private String emergencyContact;
    private String emergencyPhone;
    private String address;
}
