package com.opom.bdms.features.bloodInventory.dto.response;

import com.opom.bdms.dto.response.MasterData;
import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodInventoryStatus;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record BloodInventoryResponse(
        Long id,
        Long donationId,
        Long hospitalId,
        BloodGroup bloodGroup,
        Integer units,
        LocalDate collectedAt,
        LocalDate expiredAt,
        BloodInventoryStatus status,
        Long bloodRequestId,
        MasterData masterData
) {}
