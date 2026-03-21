package com.opom.bdms.features.bloodInventory.mapper;

import com.opom.bdms.entity.BloodInventory;
import com.opom.bdms.entity.BloodRequest;
import com.opom.bdms.entity.Donation;
import com.opom.bdms.entity.Hospital;
import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.BloodInventoryStatus;
import com.opom.bdms.features.bloodInventory.dto.request.BloodInventoryRequest;
import com.opom.bdms.features.bloodInventory.dto.response.BloodInventoryResponse;
import com.opom.bdms.mapper.MasterDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BloodInventoryMapper{

    private final MasterDataMapper masterDataMapper;

    public BloodInventory toEntity(BloodInventoryRequest request, Donation donation, Hospital hospital, BloodRequest bloodRequest) {
        BloodInventory entity = new BloodInventory();
        entity.setDonation(donation);
        entity.setHospital(hospital);
        entity.setBloodGroup(request.bloodGroup());
        entity.setUnits(request.units());
        entity.setCollectedAt(request.collectedAt());
        entity.setExpiredAt(request.expiredAt());
        entity.setStatus(request.status());
        entity.setBloodRequest(bloodRequest);

        return entity;
    }

    public BloodInventoryResponse toResponse(BloodInventory entity) {
        if (entity == null) {
            return null;
        }

        return BloodInventoryResponse.builder()
                .id(entity.getId())
                .donationId(entity.getDonation().getId())
                .hospitalId(entity.getHospital().getId())
                .bloodGroup(entity.getBloodGroup())
                .units(entity.getUnits())
                .collectedAt(entity.getCollectedAt())
                .expiredAt(entity.getExpiredAt())
                .status(entity.getStatus())
                .bloodRequestId(entity.getBloodRequest() == null ? null : entity.getBloodRequest().getId())
                .masterData(masterDataMapper.toMasterData(entity))
                .build();
    }

    public void updateEntity(BloodInventory entity, BloodInventoryRequest request, Donation donation, Hospital hospital, BloodRequest bloodRequest) {
        entity.setDonation(donation);
        entity.setHospital(hospital);
        entity.setBloodGroup(request.bloodGroup());
        entity.setUnits(request.units());
        entity.setCollectedAt(request.collectedAt());
        entity.setExpiredAt(request.expiredAt());
        entity.setStatus(request.status());
        entity.setBloodRequest(bloodRequest);
    }
}

