package com.opom.bdms.features.donar.service.impl;

import com.opom.bdms.entity.Donor;
import com.opom.bdms.exception.DuplicateEntityException;
import com.opom.bdms.features.donar.dto.request.DonorFilter;
import com.opom.bdms.features.donar.dto.request.DonorRequest;
import com.opom.bdms.features.donar.dto.response.DonorResponse;
import com.opom.bdms.features.donar.mapper.DonorMapper;
import com.opom.bdms.features.donar.service.DonorService;
import com.opom.bdms.repository.DonorRepository;
import com.opom.bdms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DonorServiceImpl extends BaseServiceImpl<Donor, DonorRequest, DonorResponse, DonorFilter>
        implements DonorService {

    private final DonorRepository donorRepository;
    private final DonorMapper donorMapper;

    public DonorServiceImpl(DonorRepository donorRepository, DonorMapper donorMapper) {
        super(donorRepository);
        this.donorRepository = donorRepository;
        this.donorMapper = donorMapper;
    }

    @Override
    protected void validateBeforeCreate(DonorRequest request) {
        if (request.nrc_no() != null && donorRepository.existsByNrcNo(request.nrc_no())) {
            throw new DuplicateEntityException("Donor with NRC number '" + request.nrc_no() + "' already exists.");
        }
    }

    @Override
    protected void validateBeforeUpdate(Long id, DonorRequest request, Donor existingEntity) {
        // Only validate NRC if it's being changed and it's not null in the request
        if (request.nrc_no() != null && !Objects.equals(request.nrc_no(), existingEntity.getNrcNo())) {
            if (donorRepository.existsByNrcNoAndIdNot(request.nrc_no(), id)) {
                throw new DuplicateEntityException("Donor with NRC number '" + request.nrc_no() + "' already exists.");
            }
        }
    }

    @Override
    protected void updateEntityFromRequest(Donor entity, DonorRequest request) {
        donorMapper.updateEntity(entity, request);
    }

    @Override
    protected Donor mapRequestToEntity(DonorRequest request) {
        return donorMapper.toEntity(request);
    }

    @Override
    protected DonorResponse mapEntityToResponse(Donor entity) {
        return donorMapper.toResponse(entity);
    }

    @Override
    protected java.util.Map<String, String> getFieldMapping() {
        return java.util.Map.of(
                "nrc_no", "nrcNo",
                "date_of_birth", "dateOfBirth",
                "user_id", "user.id");
    }
}
