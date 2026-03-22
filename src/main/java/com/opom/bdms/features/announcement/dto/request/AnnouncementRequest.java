package com.opom.bdms.features.announcement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AnnouncementRequest(
        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Content is required")
        String content,

        @NotNull(message = "Expired Date is required")
        LocalDate expiredAt
) {}
