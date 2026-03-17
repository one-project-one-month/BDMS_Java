package com.opom.bdms.features.permission.service;

import com.opom.bdms.features.permission.dto.request.PermissionFilter;
import com.opom.bdms.features.permission.dto.request.PermissionRequest;
import com.opom.bdms.features.permission.dto.response.PermissionResponse;
import com.opom.bdms.service.BaseService;

public interface PermissionService extends BaseService<PermissionRequest, PermissionResponse, PermissionFilter> {
}
