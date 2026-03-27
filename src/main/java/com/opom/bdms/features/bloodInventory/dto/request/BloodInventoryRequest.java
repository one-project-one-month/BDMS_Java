package com.opom.bdms.features.bloodInventory.dto.request;

import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodInventoryStatus;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record BloodInventoryRequest(
        @NotNull(message = "Donation ID is required")
        Long donationId,

        @NotNull(message = "Hospital ID is required")
        Long hospitalId,

        @NotNull(message = "Blood group is required")
        BloodGroup bloodGroup,

        @NotNull(message = "Units are required")
        Integer units,

        @NotNull(message = "Collected At date is required")
        LocalDate collectedAt,

        @NotNull(message = "Expired At date is required")
        LocalDate expiredAt,

        @NotNull(message = "Status is required")
        BloodInventoryStatus status,

        Long bloodRequestId
) {}
