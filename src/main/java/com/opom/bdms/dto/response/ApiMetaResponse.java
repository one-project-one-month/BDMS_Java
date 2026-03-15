package com.opom.bdms.dto.response;

import lombok.Builder;

@Builder
public record ApiMetaResponse(
        String endpoint,
        String method,
        int totalItems,
        int totalPages,
        int currentPage
) {}
