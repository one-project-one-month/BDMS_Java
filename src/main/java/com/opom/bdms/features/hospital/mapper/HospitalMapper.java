package com.opom.bdms.features.hospital.mapper;

import com.opom.bdms.entity.Hospital;
import com.opom.bdms.features.hospital.dto.request.HospitalRequest;
import com.opom.bdms.features.hospital.dto.response.HospitalResponse;
import com.opom.bdms.mapper.MasterDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HospitalMapper {

    private final MasterDataMapper masterDataMapper;

    public Hospital toEntity(HospitalRequest request){
        Hospital entity = new Hospital();
        entity.setName(request.name());
        entity.setAddress(request.address());
        entity.setPhone(request.phone());
        entity.setEmail(request.email());
        entity.setIsVerified(request.isVerified());
        return entity;
    }

    public HospitalResponse toResponse(Hospital entity){
        if(entity == null){
            return null;
        }

        return HospitalResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .isVerified(entity.getIsVerified())
                .build();
    }

    public void updateEntity(Hospital entity, HospitalRequest request) {

        entity.setName(request.name());
        entity.setAddress(request.address());
        entity.setPhone(request.phone());
        entity.setEmail(request.email());
        entity.setIsVerified(request.isVerified());
    }

}
