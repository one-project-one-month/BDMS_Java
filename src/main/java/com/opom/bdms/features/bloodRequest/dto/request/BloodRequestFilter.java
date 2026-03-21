package com.opom.bdms.features.bloodRequest.dto.request;

import com.opom.bdms.dto.request.BaseFilter;
import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodRequestStatus;
import com.opom.bdms.enums.Urgency;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class BloodRequestFilter extends BaseFilter {
    private String bloodRequestCode;
    private String patientName;
    private BloodGroup bloodGroup;
    private Integer unitsRequired;
    private String contactPhone;
    private Urgency urgency;
    private LocalDate requiredDate;
    private BloodRequestStatus status;
    private String reason;
    private LocalDateTime approvedAt;
}
