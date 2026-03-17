package com.opom.bdms.features.permission.dto.response;

import com.opom.bdms.dto.response.MasterData;
import lombok.Builder;

@Builder
public record PermissionResponse(
        Long id,
        String name,
        MasterData masterData
) {}
