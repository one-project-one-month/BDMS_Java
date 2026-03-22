package com.opom.bdms.features.certificate.dto.request;

import com.opom.bdms.dto.request.BaseFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CertificateFilter extends BaseFilter {

    private String certificate_title;
    private String certificate_description;
    private String certificate_date;
    private Long user_id;
}
