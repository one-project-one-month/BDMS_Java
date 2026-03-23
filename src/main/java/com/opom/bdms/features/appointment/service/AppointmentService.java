package com.opom.bdms.features.appointment.service;

import com.opom.bdms.features.appointment.dto.request.AppointmentFilter;
import com.opom.bdms.features.appointment.dto.request.AppointmentRequest;
import com.opom.bdms.features.appointment.dto.response.AppointmentResponse;
import com.opom.bdms.service.BaseService;

public interface AppointmentService extends BaseService<AppointmentRequest, AppointmentResponse, AppointmentFilter> {
}
