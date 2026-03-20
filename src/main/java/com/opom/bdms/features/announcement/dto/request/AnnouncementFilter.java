package com.opom.bdms.features.announcement.dto.request;

import com.opom.bdms.dto.request.BaseFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AnnouncementFilter extends BaseFilter {
    private String title;
}
