package com.opom.bdms.mapper;

import com.opom.bdms.dto.response.MasterData;
import com.opom.bdms.entity.MasterEntity;
import org.springframework.stereotype.Component;

@Component
public class MasterDataMapper {

    public MasterData toMasterData(MasterEntity entity) {
        if (entity == null) {
            return null;
        }
        return MasterData.builder()
                .id(entity.getId())
                .createdBy(entity.getCreatedBy() != null ? entity.getCreatedBy().getId() : null)
                .updatedBy(entity.getUpdatedBy() != null ? entity.getUpdatedBy().getId() : null)
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
