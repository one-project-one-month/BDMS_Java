package com.opom.bdms.features.donation.service.impl;

import com.opom.bdms.entity.*;
import com.opom.bdms.features.donation.dto.request.DonationFilter;
import com.opom.bdms.features.donation.dto.request.DonationRequest;
import com.opom.bdms.features.donation.dto.response.DonationResponse;
import com.opom.bdms.features.donation.mapper.DonationMapper;
import com.opom.bdms.features.donation.service.DonationService;
import com.opom.bdms.repository.*;
import com.opom.bdms.service.impl.BaseServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DonationServiceImpl extends BaseServiceImpl<Donation, DonationRequest, DonationResponse, DonationFilter> implements DonationService {

    private final DonorRepository donorRepository;
    private final HospitalRepository hospitalRepository;
    private final BloodRequestRepository bloodRequestRepository;
    private final DonationMapper donationMapper;

    public DonationServiceImpl(DonationRepository donationRepository,
                               DonorRepository donorRepository,
                               HospitalRepository hospitalRepository,
                               BloodRequestRepository bloodRequestRepository,
                               DonationMapper donationMapper) {
        super(donationRepository);
        this.donorRepository = donorRepository;
        this.hospitalRepository = hospitalRepository;
        this.bloodRequestRepository = bloodRequestRepository;
        this.donationMapper = donationMapper;
    }

    @Override
    protected Donation mapRequestToEntity(DonationRequest request) {
        Donor donor = donorRepository.findById(request.donorId())
                .orElseThrow(() -> new EntityNotFoundException("Donor not found with id: " + request.donorId()));

        Hospital hospital = hospitalRepository.findById(request.hospitalId())
                .orElseThrow(() -> new EntityNotFoundException("Hospital not found with id: " + request.hospitalId()));

        BloodRequest bloodRequest = null;
        if (request.bloodRequestId() != null) {
            bloodRequest = bloodRequestRepository.findById(request.bloodRequestId())
                    .orElseThrow(() -> new EntityNotFoundException("BloodRequest not found with id: " + request.bloodRequestId()));
        }

        return donationMapper.toEntity(request, donor, hospital, bloodRequest);
    }

    @Override
    protected DonationResponse mapEntityToResponse(Donation entity) {
        return donationMapper.toResponse(entity);
    }

    @Override
    protected void updateEntityFromRequest(Donation entity, DonationRequest request) {
        Donor donor = donorRepository.findById(request.donorId())
                .orElseThrow(() -> new EntityNotFoundException("Donor not found with id: " + request.donorId()));

        Hospital hospital = hospitalRepository.findById(request.hospitalId())
                .orElseThrow(() -> new EntityNotFoundException("Hospital not found with id: " + request.hospitalId()));

        BloodRequest bloodRequest = null;
        if (request.bloodRequestId() != null) {
            bloodRequest = bloodRequestRepository.findById(request.bloodRequestId())
                    .orElseThrow(() -> new EntityNotFoundException("BloodRequest not found with id: " + request.bloodRequestId()));
        }

        donationMapper.updateEntity(entity, request, donor, hospital, bloodRequest);
    }
}