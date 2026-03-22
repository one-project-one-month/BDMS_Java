package com.opom.bdms.features.certificate.mapper;

import com.opom.bdms.entity.Certificate;
import com.opom.bdms.entity.User;
import com.opom.bdms.features.certificate.dto.request.CertificateRequest;
import com.opom.bdms.features.certificate.dto.response.CertificateResponse;
import com.opom.bdms.mapper.MasterDataMapper;
import com.opom.bdms.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertificateMapper {

    private final UserRepository userRepository;
    private final MasterDataMapper masterDataMapper;

    public Certificate toEntity(CertificateRequest certificateRequest) {
        Certificate certificate = new Certificate();
        if (certificateRequest.user_id() != null) {
            certificate.setUser(findById(certificateRequest.user_id()));
        }
        if (certificateRequest.certificate_title() != null) {
            certificate.setCertificateTitle(certificateRequest.certificate_title());
        }
        if (certificateRequest.certificate_description() != null) {
            certificate.setCertificateDescription(certificateRequest.certificate_description());
        }
        if (certificateRequest.certificate_date() != null) {
            certificate.setCertificateDate(certificateRequest.certificate_date());
        }
        return certificate;
    }

    public CertificateResponse toResponse(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        return CertificateResponse.builder()
                .id(certificate.getId())
                .user_id(certificate.getUser() != null ? certificate.getUser().getId() : null)
                .certificate_title(certificate.getCertificateTitle())
                .certificate_description(certificate.getCertificateDescription())
                .certificate_date(certificate.getCertificateDate())
                .masterData(masterDataMapper.toMasterData(certificate))
                .build();
    }

    public void updateEntity(Certificate certificate, CertificateRequest certificateRequest) {
        if (certificateRequest.user_id() != null) {
            certificate.setUser(findById(certificateRequest.user_id()));
        }
        if (certificateRequest.certificate_title() != null) {
            certificate.setCertificateTitle(certificateRequest.certificate_title());
        }
        if (certificateRequest.certificate_description() != null) {
            certificate.setCertificateDescription(certificateRequest.certificate_description());
        }
        if (certificateRequest.certificate_date() != null) {
            certificate.setCertificateDate(certificateRequest.certificate_date());
        }

    }

    private User findById(Long userId) {

           return userRepository.findById(userId).orElseThrow(()->new EntityNotFoundException("User Not found with id: "+userId));
    }
}
