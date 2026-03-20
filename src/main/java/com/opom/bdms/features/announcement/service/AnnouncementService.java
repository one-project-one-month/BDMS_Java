package com.opom.bdms.features.announcement.service;

import com.opom.bdms.features.announcement.dto.request.AnnouncementFilter;
import com.opom.bdms.features.announcement.dto.request.AnnouncementRequest;
import com.opom.bdms.features.announcement.dto.response.AnnouncementResponse;
import com.opom.bdms.service.BaseService;

public interface AnnouncementService extends BaseService<AnnouncementRequest,AnnouncementResponse, AnnouncementFilter> {
}
