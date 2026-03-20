package com.opom.bdms.features.bloodRequest.service;

import com.opom.bdms.features.bloodRequest.dto.request.BloodRequestFilter;
import com.opom.bdms.features.bloodRequest.dto.request.BloodRequestRequest;
import com.opom.bdms.features.bloodRequest.dto.response.BloodRequestResponse;
import com.opom.bdms.service.BaseService;

public interface BloodRequestService extends BaseService<BloodRequestRequest, BloodRequestResponse, BloodRequestFilter> {
}
