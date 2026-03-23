package com.opom.bdms.features.appointment.mapper;

import com.opom.bdms.entity.*;
import com.opom.bdms.features.appointment.dto.request.AppointmentRequest;
import com.opom.bdms.features.appointment.dto.response.AppointmentResponse;
import com.opom.bdms.mapper.MasterDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {

    private final MasterDataMapper masterDataMapper;

    public Appointment toEntity(AppointmentRequest request, User user, Hospital hospital, Donation donation, BloodRequest bloodRequest) {
        Appointment entity = new Appointment();
        setEntityFields(entity, request, user, hospital, donation, bloodRequest);
        return entity;
    }

    public AppointmentResponse toResponse(Appointment entity) {
        if (entity == null) return null;

        return AppointmentResponse.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .hospitalId(entity.getHospital().getId())
                .donationId(entity.getDonation().getId())
                .bloodRequestId(entity.getBloodRequest().getId())
                .appointmentDate(entity.getAppointmentDate())
                .appointmentTime(entity.getAppointmentTime())
                .appointmentStatus(entity.getStatus())
                .remarks(entity.getRemarks())
                .masterData(masterDataMapper.toMasterData(entity))
                .build();
    }

    public void updateEntity(Appointment entity, AppointmentRequest request, User user, Hospital hospital, Donation donation, BloodRequest bloodRequest) {
        setEntityFields(entity, request, user, hospital, donation, bloodRequest);
    }

    private void setEntityFields(Appointment entity, AppointmentRequest request, User user, Hospital hospital, Donation donation, BloodRequest bloodRequest) {
        entity.setUser(user);
        entity.setHospital(hospital);
        entity.setDonation(donation);
        entity.setBloodRequest(bloodRequest);
        entity.setAppointmentDate(request.appointmentDate());
        entity.setAppointmentTime(request.appointmentTime());
        entity.setStatus(request.appointmentStatus());
        entity.setRemarks(request.remarks());
    }

}
