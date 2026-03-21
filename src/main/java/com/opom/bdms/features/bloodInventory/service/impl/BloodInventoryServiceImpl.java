package com.opom.bdms.features.bloodInventory.service.impl;

import com.opom.bdms.entity.BloodInventory;
import com.opom.bdms.entity.BloodRequest;
import com.opom.bdms.entity.Donation;
import com.opom.bdms.entity.Hospital;
import com.opom.bdms.features.bloodInventory.dto.request.BloodInventoryFilter;
import com.opom.bdms.features.bloodInventory.dto.request.BloodInventoryRequest;
import com.opom.bdms.features.bloodInventory.dto.response.BloodInventoryResponse;
import com.opom.bdms.features.bloodInventory.mapper.BloodInventoryMapper;
import com.opom.bdms.features.bloodInventory.service.BloodInventoryService;
import com.opom.bdms.repository.*;
import com.opom.bdms.service.impl.BaseServiceImpl;
import com.opom.bdms.util.RepoHelper;
import org.springframework.stereotype.Service;

@Service
public class BloodInventoryServiceImpl extends BaseServiceImpl<BloodInventory, BloodInventoryRequest, BloodInventoryResponse, BloodInventoryFilter> implements BloodInventoryService {

    private final BloodInventoryRepository bloodInventoryRepository;
    private final BloodInventoryMapper bloodInventoryMapper;
    private final DonationRepository donationRepository;
    private final HospitalRepository hospitalRepository;
    private final BloodRequestRepository bloodRequestRepository;


    public BloodInventoryServiceImpl(BloodInventoryRepository bloodInventoryRepository,
                                        BloodInventoryMapper bloodInventoryMapper,
                                        DonationRepository donationRepository,
                                        HospitalRepository hospitalRepository,
                                        BloodRequestRepository bloodRequestRepository) {
        super(bloodInventoryRepository);
        this.bloodInventoryRepository = bloodInventoryRepository;
        this.bloodInventoryMapper = bloodInventoryMapper;
        this.donationRepository = donationRepository;
        this.hospitalRepository = hospitalRepository;
        this.bloodRequestRepository = bloodRequestRepository;
    }


    @Override
    protected BloodInventory mapRequestToEntity(BloodInventoryRequest request) {
        Donation donation = RepoHelper.findByIdOrThrow(donationRepository, request.donationId(), "Donation", "donation id");
        Hospital hospital = RepoHelper.findByIdOrThrow(hospitalRepository, request.hospitalId(), "Hospital", "hospital id");
        BloodRequest bloodRequest = null;
        if (request.bloodRequestId() != null) {
            bloodRequest = RepoHelper.findByIdOrThrow(bloodRequestRepository, request.bloodRequestId(), "Blood Request", "blood request id");
        }
        return bloodInventoryMapper.toEntity(request, donation, hospital, bloodRequest);
    }

    @Override
    protected BloodInventoryResponse mapEntityToResponse(BloodInventory entity) {
        return bloodInventoryMapper.toResponse(entity);
    }

    @Override
    protected void updateEntityFromRequest(BloodInventory entity, BloodInventoryRequest request) {
        Donation donation = RepoHelper.findByIdOrThrow(donationRepository, request.donationId(), "Donation", "donation id");
        Hospital hospital = RepoHelper.findByIdOrThrow(hospitalRepository, request.hospitalId(), "Hospital", "hospital id");
        BloodRequest bloodRequest = null;
        if (request.bloodRequestId() != null) {
            bloodRequest = RepoHelper.findByIdOrThrow(bloodRequestRepository, request.bloodRequestId(), "Blood Request", "blood request id");
        }
        bloodInventoryMapper.updateEntity(entity, request, donation, hospital, bloodRequest);
    }
}
