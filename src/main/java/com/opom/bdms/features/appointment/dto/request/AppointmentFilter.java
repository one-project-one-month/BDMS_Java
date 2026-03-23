package com.opom.bdms.features.appointment.dto.request;

import com.opom.bdms.dto.request.BaseFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class AppointmentFilter extends BaseFilter {
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
}
