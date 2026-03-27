package com.opom.bdms.features.announcement.mapper;

import com.opom.bdms.entity.Announcement;
import com.opom.bdms.entity.Permission;
import com.opom.bdms.features.announcement.dto.request.AnnouncementRequest;
import com.opom.bdms.features.announcement.dto.response.AnnouncementResponse;
import com.opom.bdms.features.permission.dto.request.PermissionRequest;
import com.opom.bdms.mapper.MasterDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnnouncementMapper {

    private final MasterDataMapper masterDataMapper;

    public Announcement toEntity(AnnouncementRequest request){
        Announcement entity = new Announcement();
        entity.setTitle(request.title());
        entity.setContent(request.content());
        entity.setExpiredAt(request.expiredAt());

        return entity;
    }

    public AnnouncementResponse toResponse(Announcement entity){
        if(entity == null){
            return  null;
        }

        return AnnouncementResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .expiredAt(entity.getExpiredAt())
                .build();
    }

    public void updateEntity(Announcement entity, AnnouncementRequest request) {

        entity.setTitle(request.title());
        entity.setContent(request.content());
        entity.setExpiredAt(request.expiredAt());
    }

}
