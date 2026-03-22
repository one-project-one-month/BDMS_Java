package com.opom.bdms.features.certificate.service.impl;

import com.opom.bdms.entity.Certificate;
import com.opom.bdms.features.certificate.dto.request.CertificateFilter;
import com.opom.bdms.features.certificate.dto.request.CertificateRequest;
import com.opom.bdms.features.certificate.dto.response.CertificateResponse;
import com.opom.bdms.features.certificate.mapper.CertificateMapper;
import com.opom.bdms.features.certificate.service.CertificateService;
import com.opom.bdms.repository.CertificateRepository;
import com.opom.bdms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl extends BaseServiceImpl<Certificate, CertificateRequest, CertificateResponse, CertificateFilter> implements CertificateService {

    private final CertificateMapper certificateMapper;
    private final CertificateRepository certificateRepository;


    public CertificateServiceImpl(CertificateMapper certificateMapper, CertificateRepository certificateRepository) {
        super(certificateRepository);
        this.certificateMapper = certificateMapper;
        this.certificateRepository = certificateRepository;
    }

//    @Override
//    protected void validateBeforeCreate(CertificateRequest certificateRequest) {
//        if(certificateRequest.userId()!=null && certificateRequest.userId()!=0){
//
//        }
//    }

//    @Override
//    protected void validateBeforeUpdate(Long id, CertificateRequest certificateRequest, Certificate existingEntity) {
//        super.validateBeforeUpdate(id, certificateRequest, existingEntity);
//    }


    @Override
    protected Certificate mapRequestToEntity(CertificateRequest certificateRequest) {
        return certificateMapper.toEntity(certificateRequest);
    }

    @Override
    protected CertificateResponse mapEntityToResponse(Certificate entity) {
        return certificateMapper.toResponse(entity);
    }

    @Override
    protected void updateEntityFromRequest(Certificate entity, CertificateRequest request) {
        certificateMapper.updateEntity(entity, request);
    }

    @Override
    protected java.util.Map<String, String> getFieldMapping() {
        return java.util.Map.of(
                "certificate_title", "certificateTitle",
                "certificate_description", "certificateDescription",
                "certificate_date", "certificateDate",
                "user_id", "user.id"
        );
    }


}