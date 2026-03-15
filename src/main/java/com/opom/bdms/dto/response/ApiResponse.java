package com.opom.bdms.dto.response;

import lombok.Builder;

@Builder
public record ApiResponse(
        int success,
        int code,
        ApiMetaResponse meta,
        Object data,
        String message
) {}
