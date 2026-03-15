package com.opom.bdms.permission.service;

import com.opom.bdms.permission.dto.request.PermissionFilter;
import com.opom.bdms.permission.dto.request.PermissionRequest;
import com.opom.bdms.permission.dto.response.PermissionResponse;
import com.opom.bdms.service.BaseService;

public interface PermissionService extends BaseService<PermissionRequest, PermissionResponse, PermissionFilter> {
}
