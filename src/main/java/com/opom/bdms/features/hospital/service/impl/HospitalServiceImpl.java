package com.opom.bdms.features.hospital.service.impl;


import com.opom.bdms.entity.Hospital;
import com.opom.bdms.features.hospital.dto.request.HospitalFilter;
import com.opom.bdms.features.hospital.dto.request.HospitalRequest;
import com.opom.bdms.features.hospital.dto.response.HospitalResponse;
import com.opom.bdms.features.hospital.mapper.HospitalMapper;
import com.opom.bdms.features.hospital.service.HospitalService;
import com.opom.bdms.repository.HospitalRepository;
import com.opom.bdms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl extends BaseServiceImpl<Hospital, HospitalRequest,HospitalResponse, HospitalFilter> implements HospitalService {

    private final HospitalMapper hospitalMapper;
    private final HospitalRepository hospitalRepository;

    public HospitalServiceImpl(HospitalMapper hospitalMapper, HospitalRepository hospitalRepository) {
        super(hospitalRepository);
        this.hospitalMapper = hospitalMapper;
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    protected Hospital mapRequestToEntity(HospitalRequest request) {
        return hospitalMapper.toEntity(request);
    }

    @Override
    protected HospitalResponse mapEntityToResponse(Hospital entity) {
        return hospitalMapper.toResponse(entity);
    }

    @Override
    protected void updateEntityFromRequest(Hospital entity, HospitalRequest request) {
        hospitalMapper.updateEntity(entity,request);
    }
}
