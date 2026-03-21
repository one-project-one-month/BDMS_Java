package com.opom.bdms.features.donar.service;

import com.opom.bdms.features.donar.dto.request.DonorFilter;
import com.opom.bdms.features.donar.dto.request.DonorRequest;
import com.opom.bdms.features.donar.dto.response.DonorResponse;
import com.opom.bdms.service.BaseService;

public interface DonorService extends BaseService<DonorRequest, DonorResponse, DonorFilter> {
}
