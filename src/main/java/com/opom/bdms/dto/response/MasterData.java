package com.opom.bdms.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MasterData(
        Long id,
        Long createdBy,
        Long updatedBy,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
