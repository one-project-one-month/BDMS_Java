package com.opom.bdms.features.bloodRequest.mapper;

import com.opom.bdms.entity.BloodRequest;
import com.opom.bdms.entity.Hospital;
import com.opom.bdms.entity.User;
import com.opom.bdms.features.bloodRequest.dto.request.BloodRequestRequest;
import com.opom.bdms.features.bloodRequest.dto.response.BloodRequestResponse;
import com.opom.bdms.mapper.MasterDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BloodRequestMapper {

    private final MasterDataMapper masterDataMapper;

    public BloodRequest toEntity(BloodRequestRequest request, User user, Hospital hospital) {
        BloodRequest entity = new BloodRequest();
        setEntityFields(entity, request, user, hospital);
        return entity;
    }

    public BloodRequestResponse toResponse(BloodRequest entity) {
        if (entity == null) {
            return null;
        }
        return BloodRequestResponse.builder()
                .id(entity.getId())
                .bloodRequestCode(entity.getBloodRequestCode())
                .patientName(entity.getPatientName())
                .bloodGroup(entity.getBloodGroup())
                .unitsRequired(entity.getUnitsRequired())
                .contactPhone(entity.getContactPhone())
                .urgency(entity.getUrgency())
                .requiredDate(entity.getRequiredDate())
                .status(entity.getStatus())
                .reason(entity.getReason())
                .approvedAt(entity.getApprovedAt())
                .userId(entity.getUser().getId())
                .hospitalId(entity.getHospital().getId())
                .masterData(masterDataMapper.toMasterData(entity))
                .build();
    }

    public void updateEntity(BloodRequest entity, BloodRequestRequest request, User user, Hospital hospital) {
        setEntityFields(entity, request, user, hospital);
    }

    private void setEntityFields(BloodRequest entity, BloodRequestRequest request, User user, Hospital hospital) {
        entity.setBloodRequestCode(request.bloodRequestCode());
        entity.setPatientName(request.patientName());
        entity.setBloodGroup(request.bloodGroup());
        entity.setUnitsRequired(request.unitsRequired());
        entity.setContactPhone(request.contactPhone());
        entity.setUrgency(request.urgency());
        entity.setRequiredDate(request.requiredDate());
        entity.setStatus(request.status());
        entity.setReason(request.reason());
        entity.setUser(user);
        entity.setHospital(hospital);
    }

}
