package com.opom.bdms.features.bloodInventory.service;

import com.opom.bdms.features.bloodInventory.dto.request.BloodInventoryFilter;
import com.opom.bdms.features.bloodInventory.dto.request.BloodInventoryRequest;
import com.opom.bdms.features.bloodInventory.dto.response.BloodInventoryResponse;
import com.opom.bdms.service.BaseService;

public interface BloodInventoryService extends BaseService<BloodInventoryRequest, BloodInventoryResponse, BloodInventoryFilter> {
}
