package com.opom.bdms.service.impl;

import com.opom.bdms.dto.request.PageAndFilterDTO;
import com.opom.bdms.dto.response.PaginationDTO;
import com.opom.bdms.entity.MasterEntity;
import com.opom.bdms.repository.BaseRepository;
import com.opom.bdms.repository.specification.GenericSpecification;
import com.opom.bdms.service.BaseService;
import com.opom.bdms.util.PaginationHelper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<ENTITY extends MasterEntity, REQUEST, RESPONSE, FILTER> implements BaseService<REQUEST, RESPONSE, FILTER> {

    protected final BaseRepository<ENTITY> repository;
    protected final JpaSpecificationExecutor<ENTITY> specificationExecutor;
    private final GenericSpecification<ENTITY> genericSpecification = new GenericSpecification<>();

    protected BaseServiceImpl(BaseRepository<ENTITY> repository) {
        this.repository = repository;
        this.specificationExecutor = repository;
    }

    @Override
    @Transactional
    public RESPONSE create(REQUEST request) {
        validateBeforeCreate(request);
        ENTITY entity = mapRequestToEntity(request);
        ENTITY savedEntity = repository.save(entity);
        return mapEntityToResponse(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public RESPONSE findById(Long id) {
        ENTITY entity = findByIdOrThrow(id);
        return mapEntityToResponse(entity);
    }

    @Override
    @Transactional
    public RESPONSE update(Long id, REQUEST request) {
        ENTITY entity = findByIdOrThrow(id);
        validateBeforeUpdate(id, request, entity);
        updateEntityFromRequest(entity, request);
        ENTITY updatedEntity = repository.save(entity);
        return mapEntityToResponse(updatedEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteMany(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            return;
        }
        repository.deleteAllById(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public PaginationDTO<RESPONSE> getAll(PageAndFilterDTO<FILTER> pageAndFilterDTO) {
        if (pageAndFilterDTO.getSortBy() != null && !pageAndFilterDTO.getSortBy().isEmpty()) {
            validateSortBy(pageAndFilterDTO.getSortBy());
        }

        FILTER filter = pageAndFilterDTO.getFilter();
        Map<String, Object> keywordMap = toMap(filter, getFieldMapping());

        List<String> fields = new ArrayList<>(keywordMap.keySet());
        Specification<ENTITY> spec = genericSpecification.getSpecification(keywordMap, fields);

        Pageable pageable = buildPageable(pageAndFilterDTO);

        Page<ENTITY> page;
        if (spec != null) {
            page = specificationExecutor.findAll(spec, pageable);
        } else {
            page = repository.findAll(pageable);
        }

        List<RESPONSE> content = page.getContent().stream()
                .map(this::mapEntityToResponse)
                .toList();

        return PaginationHelper.getResponse(page, content);
    }

    private Pageable buildPageable(PageAndFilterDTO<FILTER> pageAndFilterDTO) {
        String sortBy = pageAndFilterDTO.getSortBy() != null && !pageAndFilterDTO.getSortBy().isEmpty()
                ? pageAndFilterDTO.getSortBy()
                : "id";
        String sortDirection = pageAndFilterDTO.getSortDirection() != null && !pageAndFilterDTO.getSortDirection().isEmpty()
                ? pageAndFilterDTO.getSortDirection()
                : "ASC";
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        return PageRequest.of(pageAndFilterDTO.getPage(), pageAndFilterDTO.getSize(), sort);
    }

    protected abstract ENTITY mapRequestToEntity(REQUEST request);

    protected abstract RESPONSE mapEntityToResponse(ENTITY entity);

    protected abstract void updateEntityFromRequest(ENTITY entity, REQUEST request);

    /**
     * Override this method to provide field mapping for nested properties.
     * Example: Map.of("profileId", "profileId.profileId", "skillSubcategoryId", "skillSubcategoryId.skillSubcategoryId")
     */
    protected Map<String, String> getFieldMapping() {
        return Map.of();
    }

    /**
     * Override this method to provide custom validation for sortBy field.
     * Default implementation does nothing - JPA will handle invalid sort fields.
     */
    protected void validateSortBy(String sortBy) {
        // Default implementation - can be overridden in subclasses for custom validation
    }

    /**
     * Override this method to validate before creating a new entity.
     * Use this to check for duplicate unique fields (e.g., email, code, name).
     * Throw DuplicateEntityException if validation fails.
     *
     * @param request The request DTO containing data for the new entity
     * @throws com.opom.bdms.exception.DuplicateEntityException if a unique constraint would be violated
     */
    protected void validateBeforeCreate(REQUEST request) {
        // Default implementation does nothing
        // Override in subclasses to add validation logic
    }

    /**
     * Override this method to validate before updating an existing entity.
     * Use this to check for duplicate unique fields, excluding the current entity.
     * Throw DuplicateEntityException if validation fails.
     *
     * @param id The ID of the entity being updated
     * @param request The request DTO containing updated data
     * @param existingEntity The existing entity being updated
     * @throws com.opom.bdms.exception.DuplicateEntityException if a unique constraint would be violated
     */
    protected void validateBeforeUpdate(Long id, REQUEST request, ENTITY existingEntity) {
        // Default implementation does nothing
        // Override in subclasses to add validation logic
    }

    private ENTITY findByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
    }

    private Map<String, Object> toMap(FILTER filter, Map<String, String> fieldMapping) {
        if (filter == null) {
            return Map.of();
        }

        Map<String, Object> map = new java.util.HashMap<>();
        Field[] fields = filter.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(filter);
                if (value != null) {
                    String fieldName = field.getName();
                    String mappedField = fieldMapping.getOrDefault(fieldName, fieldName);
                    map.put(mappedField, value);
                }
            } catch (IllegalAccessException e) {
                // Skip fields that can't be accessed
            }
        }

        return map;
    }
}
