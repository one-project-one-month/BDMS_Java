package com.opom.bdms.features.hospital.dto.request;

import com.opom.bdms.dto.request.BaseFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HospitalFilter extends BaseFilter {
    private String name;
    private String address;
    private String phone;
    private String email;
}
