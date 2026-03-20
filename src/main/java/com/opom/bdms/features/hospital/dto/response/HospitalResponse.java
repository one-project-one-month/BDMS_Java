package com.opom.bdms.features.hospital.dto.response;

import com.opom.bdms.dto.response.MasterData;
import lombok.Builder;

@Builder
public record HospitalResponse(
        Long id,
        String name,
        String address,
        String phone,
        String email,
        Boolean isVerified,
        MasterData masterData
) {}
