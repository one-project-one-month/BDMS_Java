package com.opom.bdms.features.donation.service;

import com.opom.bdms.features.donation.dto.request.DonationFilter;
import com.opom.bdms.features.donation.dto.request.DonationRequest;
import com.opom.bdms.features.donation.dto.response.DonationResponse;
import com.opom.bdms.service.BaseService;

public interface DonationService extends BaseService<DonationRequest, DonationResponse, DonationFilter> {

}