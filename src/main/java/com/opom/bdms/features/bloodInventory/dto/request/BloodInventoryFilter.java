package com.opom.bdms.features.bloodInventory.dto.request;

import com.opom.bdms.dto.request.BaseFilter;
import com.opom.bdms.enums.BloodGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class BloodInventoryFilter extends BaseFilter {
    Long hospitalId;
    BloodGroup bloodGroup;
    Integer units;
    LocalDate collectedAt;
    LocalDate expiredAt;
}
