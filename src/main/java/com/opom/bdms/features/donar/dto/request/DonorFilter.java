package com.opom.bdms.features.donar.dto.request;

import com.opom.bdms.dto.request.BaseFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DonorFilter extends BaseFilter {
    private String name;
}
