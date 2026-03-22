package com.opom.bdms.features.certificate.service;

import com.opom.bdms.features.certificate.dto.request.CertificateFilter;
import com.opom.bdms.features.certificate.dto.request.CertificateRequest;
import com.opom.bdms.features.certificate.dto.response.CertificateResponse;
import com.opom.bdms.service.BaseService;

public interface CertificateService extends BaseService<CertificateRequest, CertificateResponse, CertificateFilter> {
}
