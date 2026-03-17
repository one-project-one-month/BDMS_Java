package com.opom.bdms.features.permission.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PermissionRequest(
        @NotBlank(message = "Name is required")
        String name
) {}
