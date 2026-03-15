package com.opom.bdms.permission.service.impl;

import com.opom.bdms.entity.Permission;
import com.opom.bdms.exception.DuplicateEntityException;
import com.opom.bdms.permission.dto.request.PermissionFilter;
import com.opom.bdms.permission.dto.request.PermissionRequest;
import com.opom.bdms.permission.dto.response.PermissionResponse;
import com.opom.bdms.permission.mapper.PermissionMapper;
import com.opom.bdms.permission.service.PermissionService;
import com.opom.bdms.repository.PermissionRepository;
import com.opom.bdms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission, PermissionRequest, PermissionResponse, PermissionFilter> implements PermissionService {

    private final PermissionMapper permissionMapper;
    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository, PermissionMapper permissionMapper) {
        super(permissionRepository);
        this.permissionRepository = permissionRepository;
        this.permissionMapper = permissionMapper;
    }

    @Override
    protected void validateBeforeCreate(PermissionRequest request) {
        if (permissionRepository.existsByName(request.name())) {
            throw new DuplicateEntityException("Permission with name '" + request.name() + "' already exists.");
        }
    }

    @Override
    protected void validateBeforeUpdate(Long id, PermissionRequest request, Permission existingEntity) {
        if (permissionRepository.existsByNameAndIdNot(request.name(), id)) {
            throw new DuplicateEntityException("Permission with name '" + request.name() + "' already exists.");
        }
    }

    @Override
    protected Permission mapRequestToEntity(PermissionRequest request) {
        return permissionMapper.toEntity(request);
    }

    @Override
    protected PermissionResponse mapEntityToResponse(Permission entity) {
        return permissionMapper.toResponse(entity);
    }

    @Override
    protected void updateEntityFromRequest(Permission entity, PermissionRequest request) {
        permissionMapper.updateEntity(entity, request);
    }
}
