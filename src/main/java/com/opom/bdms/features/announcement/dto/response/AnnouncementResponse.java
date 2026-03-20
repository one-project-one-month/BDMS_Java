package com.opom.bdms.features.announcement.dto.response;


import com.opom.bdms.dto.response.MasterData;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AnnouncementResponse(
        Long id,
        String title,
        String content,
        LocalDate expiredAt,
        MasterData masterData
) {}
