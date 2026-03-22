package com.opom.bdms.features.certificate.dto.request;

public record CertificateRequest (
        Long user_id,
        String certificate_title,
        String certificate_description,
        String certificate_date
){
}
