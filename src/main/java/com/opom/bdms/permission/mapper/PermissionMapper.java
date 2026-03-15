package com.opom.bdms.permission.mapper;

import com.opom.bdms.entity.Permission;
import com.opom.bdms.mapper.MasterDataMapper;
import com.opom.bdms.permission.dto.request.PermissionRequest;
import com.opom.bdms.permission.dto.response.PermissionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PermissionMapper {

    private final MasterDataMapper masterDataMapper;

    public Permission toEntity(PermissionRequest request) {
        Permission entity = new Permission();
        entity.setName(request.name());
        return entity;
    }

    public PermissionResponse toResponse(Permission entity) {
        if (entity == null) {
            return null;
        }
        return PermissionResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .masterData(masterDataMapper.toMasterData(entity))
                .build();
    }

    public void updateEntity(Permission entity, PermissionRequest request) {
        entity.setName(request.name());
    }
}
