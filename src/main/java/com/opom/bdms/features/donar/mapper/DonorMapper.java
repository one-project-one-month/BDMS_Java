package com.opom.bdms.features.donar.mapper;

import com.opom.bdms.entity.Donor;
import com.opom.bdms.entity.User;
import com.opom.bdms.features.donar.dto.request.DonorRequest;
import com.opom.bdms.features.donar.dto.response.DonorResponse;
import com.opom.bdms.mapper.MasterDataMapper;
import com.opom.bdms.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DonorMapper {

    private final MasterDataMapper masterDataMapper;
    private final UserRepository userRepository;

    public Donor toEntity(DonorRequest request) {
        Donor entity = new Donor();
        if (request.user_id() != null) {
            entity.setUser(findUserById(request.user_id()));
        }
        entity.setNrcNo(request.nrc_no());
        entity.setDateOfBirth(request.date_of_birth());
        entity.setGender(request.gender());
        entity.setBloodGroup(request.bloodGroup());
        entity.setWeight(request.weight());
        entity.setLastDonationDate(request.lastDonationDate());
        entity.setRemarks(request.remarks());
        entity.setEmergencyContact(request.emergencyContact());
        entity.setEmergencyPhone(request.emergencyPhone());
        entity.setAddress(request.address());
        return entity;
    }

    public DonorResponse toResponse(Donor entity) {
        if (entity == null) {
            return null;
        }
        return DonorResponse.builder()
                .id(entity.getId())
                .user_id(entity.getUser() != null ? entity.getUser().getId() : null)
                .nrc_no(entity.getNrcNo())
                .date_of_birth(entity.getDateOfBirth())
                .gender(entity.getGender())
                .bloodGroup(entity.getBloodGroup())
                .weight(entity.getWeight())
                .lastDonationDate(entity.getLastDonationDate())
                .remarks(entity.getRemarks())
                .emergencyContact(entity.getEmergencyContact())
                .emergencyPhone(entity.getEmergencyPhone())
                .address(entity.getAddress())
                .masterData(masterDataMapper.toMasterData(entity))
                .build();
    }

    public void updateEntity(Donor entity, DonorRequest request) {
        if (request.user_id() != null) {
            entity.setUser(findUserById(request.user_id()));
        }
        if (request.nrc_no() != null) {
            entity.setNrcNo(request.nrc_no());
        }
        if (request.date_of_birth() != null) {
            entity.setDateOfBirth(request.date_of_birth());
        }
        if (request.gender() != null) {
            entity.setGender(request.gender());
        }
        if (request.bloodGroup() != null) {
            entity.setBloodGroup(request.bloodGroup());
        }
        if (request.weight() != null) {
            entity.setWeight(request.weight());
        }
        if (request.lastDonationDate() != null) {
            entity.setLastDonationDate(request.lastDonationDate());
        }
        if (request.remarks() != null) {
            entity.setRemarks(request.remarks());
        }
        if (request.emergencyContact() != null) {
            entity.setEmergencyContact(request.emergencyContact());
        }
        if (request.emergencyPhone() != null) {
            entity.setEmergencyPhone(request.emergencyPhone());
        }
        if (request.address() != null) {
            entity.setAddress(request.address());
        }
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
    }
}
