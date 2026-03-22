package com.opom.bdms.features.bloodRequest.service.impl;

import com.opom.bdms.entity.BloodRequest;
import com.opom.bdms.entity.Hospital;
import com.opom.bdms.entity.User;
import com.opom.bdms.exception.DuplicateEntityException;
import com.opom.bdms.features.bloodRequest.dto.request.BloodRequestFilter;
import com.opom.bdms.features.bloodRequest.dto.request.BloodRequestRequest;
import com.opom.bdms.features.bloodRequest.dto.response.BloodRequestResponse;
import com.opom.bdms.features.bloodRequest.mapper.BloodRequestMapper;
import com.opom.bdms.features.bloodRequest.service.BloodRequestService;
import com.opom.bdms.repository.BloodRequestRepository;
import com.opom.bdms.repository.HospitalRepository;
import com.opom.bdms.repository.UserRepository;
import com.opom.bdms.service.impl.BaseServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodRequestServiceImpl extends BaseServiceImpl<BloodRequest, BloodRequestRequest, BloodRequestResponse, BloodRequestFilter> implements BloodRequestService {

    private final BloodRequestMapper bloodRequestMapper;
    private final BloodRequestRepository bloodRequestRepository;
    private final UserRepository userRepository;
    private final HospitalRepository hospitalRepository;

    protected BloodRequestServiceImpl(BloodRequestRepository bloodRequestRepository, BloodRequestMapper bloodRequestMapper, UserRepository userRepository,
        HospitalRepository hospitalRepository) {
        super(bloodRequestRepository);
        this.bloodRequestRepository = bloodRequestRepository;
        this.bloodRequestMapper = bloodRequestMapper;
        this.userRepository = userRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    protected void validateBeforeCreate(BloodRequestRequest request) {
        if(bloodRequestRepository.existsByBloodRequestCode(request.bloodRequestCode())) {
            throw new DuplicateEntityException("Blood Request with code '" + request.bloodRequestCode() + "' already exists");
        }
    }

    @Override
    protected void validateBeforeUpdate(Long id, BloodRequestRequest request, BloodRequest existingEntity) {
        if(bloodRequestRepository.existsByBloodRequestCodeAndIdNot(request.bloodRequestCode(), id)) {
            throw new DuplicateEntityException("Blood Request with code '" + request.bloodRequestCode() + "' already exists");
        }
    }

    @Override
    protected BloodRequest mapRequestToEntity(BloodRequestRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found with user id: " + request.userId()));
        Hospital hospital = hospitalRepository.findById(request.hospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital not found with hospital id: " + request.hospitalId()));
        return bloodRequestMapper.toEntity(request, user, hospital);
    }

    @Override
    protected BloodRequestResponse mapEntityToResponse(BloodRequest entity) {
        return bloodRequestMapper.toResponse(entity);
    }

    @Override
    protected void updateEntityFromRequest(BloodRequest entity, BloodRequestRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Hospital hospital = hospitalRepository.findById(request.hospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital not found"));

        bloodRequestMapper.updateEntity(entity, request, user, hospital);
    }
}
