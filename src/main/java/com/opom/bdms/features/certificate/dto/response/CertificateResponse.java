package com.opom.bdms.features.certificate.dto.response;

import com.opom.bdms.dto.response.MasterData;
import lombok.Builder;

@Builder
public record CertificateResponse(
        Long id,
        Long user_id,
        String certificate_title,
        String certificate_description,
        String certificate_date,
        MasterData masterData
) {
}
