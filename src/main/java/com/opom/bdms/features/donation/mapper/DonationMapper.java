package com.opom.bdms.features.donation.mapper;

import com.opom.bdms.entity.*;
import com.opom.bdms.enums.BloodGroup;
import com.opom.bdms.enums.DonationStatus;
import com.opom.bdms.features.donation.dto.request.DonationRequest;
import com.opom.bdms.features.donation.dto.response.DonationResponse;
import com.opom.bdms.mapper.MasterDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DonationMapper {

    private final MasterDataMapper masterDataMapper;

    public Donation toEntity(DonationRequest request,
                             Donor donor,
                             Hospital hospital,
                             BloodRequest bloodRequest) {

        Donation donation = new Donation();

        donation.setDonor(donor);
        donation.setHospital(hospital);
        donation.setBloodRequest(bloodRequest);

        if (request.bloodGroup() != null) {
            donation.setBloodGroup(BloodGroup.valueOf(request.bloodGroup()));
        }
        donation.setUnitsDonated(request.unitsDonated());
        donation.setDonationDate(request.donationDate());
        donation.setRemarks(request.remarks());

        donation.setStatus(DonationStatus.PENDING); // default

        return donation;
    }

    public DonationResponse toResponse(Donation entity) {
        if (entity == null) return null;

        return DonationResponse.builder()
                .id(entity.getId())
                .donorId(entity.getDonor() != null ? entity.getDonor().getId() : null)
                .hospitalId(entity.getHospital() != null ? entity.getHospital().getId() : null)
                .bloodRequestId(entity.getBloodRequest() != null ? entity.getBloodRequest().getId() : null)
                .bloodGroup(entity.getBloodGroup() != null ? entity.getBloodGroup().name() : null)
                .unitsDonated(entity.getUnitsDonated())
                .donationDate(entity.getDonationDate())
                .remarks(entity.getRemarks())
                .masterData(masterDataMapper.toMasterData(entity))
                .build();
    }

    public void updateEntity(Donation donation,
                             DonationRequest request,
                             Donor donor,
                             Hospital hospital,
                             BloodRequest bloodRequest) {

        donation.setDonor(donor);
        donation.setHospital(hospital);
        if (bloodRequest != null) {
            donation.setBloodRequest(bloodRequest);
        } else {
            donation.setBloodRequest(null);
        }

        if (request.bloodGroup() != null) {
            donation.setBloodGroup(BloodGroup.valueOf(request.bloodGroup()));
        }
        donation.setUnitsDonated(request.unitsDonated());
        donation.setDonationDate(request.donationDate());
        donation.setRemarks(request.remarks());
    }
}