package com.opom.bdms.features.announcement.service.impl;

import com.opom.bdms.entity.Announcement;
import com.opom.bdms.features.announcement.dto.request.AnnouncementFilter;
import com.opom.bdms.features.announcement.dto.request.AnnouncementRequest;
import com.opom.bdms.features.announcement.dto.response.AnnouncementResponse;
import com.opom.bdms.features.announcement.mapper.AnnouncementMapper;
import com.opom.bdms.features.announcement.service.AnnouncementService;
import com.opom.bdms.repository.AnnouncementRepository;
import com.opom.bdms.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement, AnnouncementRequest, AnnouncementResponse, AnnouncementFilter> implements AnnouncementService {

    private final AnnouncementMapper announcementMapper;
    private final AnnouncementRepository announcementRepository;

    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository,AnnouncementMapper announcementMapper){
        super(announcementRepository);
        this.announcementMapper = announcementMapper;
        this.announcementRepository = announcementRepository;
    }
    @Override
    protected Announcement mapRequestToEntity(AnnouncementRequest request) {
        return announcementMapper.toEntity(request);
    }

    @Override
    protected AnnouncementResponse mapEntityToResponse(Announcement entity) {
        return announcementMapper.toResponse(entity);
    }

    @Override
    protected void updateEntityFromRequest(Announcement entity, AnnouncementRequest request) {
        announcementMapper.updateEntity(entity,request);
    }

}
