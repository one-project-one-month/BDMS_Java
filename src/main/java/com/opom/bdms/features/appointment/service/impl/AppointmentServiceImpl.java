package com.opom.bdms.features.appointment.service.impl;

import com.opom.bdms.entity.*;
import com.opom.bdms.exception.DuplicateEntityException;
import com.opom.bdms.features.appointment.dto.request.AppointmentFilter;
import com.opom.bdms.features.appointment.dto.request.AppointmentRequest;
import com.opom.bdms.features.appointment.dto.response.AppointmentResponse;
import com.opom.bdms.features.appointment.mapper.AppointmentMapper;
import com.opom.bdms.features.appointment.service.AppointmentService;
import com.opom.bdms.repository.*;
import com.opom.bdms.service.impl.BaseServiceImpl;
import com.opom.bdms.util.RepoHelper;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends BaseServiceImpl<Appointment, AppointmentRequest, AppointmentResponse, AppointmentFilter> implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final UserRepository userRepository;
    private final HospitalRepository hospitalRepository;
    private final DonationRepository donationRepository;
    private final BloodRequestRepository bloodRequestRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper, UserRepository userRepository,
                                  HospitalRepository hospitalRepository, DonationRepository donationRepository, BloodRequestRepository bloodRequestRepository) {
        super(appointmentRepository);
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
        this.userRepository = userRepository;
        this.hospitalRepository = hospitalRepository;
        this.donationRepository = donationRepository;
        this.bloodRequestRepository = bloodRequestRepository;
    }

    @Override
    protected void validateBeforeCreate(AppointmentRequest request) {
        if(appointmentRepository.existsByHospitalIdAndAppointmentDateAndAppointmentTime(request.hospitalId(), request.appointmentDate(), request.appointmentTime())) {
            throw new DuplicateEntityException("Appointment Request with hospital '" + request.hospitalId() +
                    "' at '" + request.appointmentDate() + " " + request.appointmentTime() + "' already exists");
        }
    }

    @Override
    protected void validateBeforeUpdate(Long id, AppointmentRequest request, Appointment existingEntity) {
        if(appointmentRepository.existsByHospitalIdAndAppointmentDateAndAppointmentTimeAndIdNot(request.hospitalId(), request.appointmentDate(), request.appointmentTime(), id)) {
            throw new DuplicateEntityException("Appointment Request with hospital '" + request.hospitalId() +
                    "' at '" + request.appointmentDate() + " " + request.appointmentTime() + "' already exists");
        }
    }

    @Override
    protected Appointment mapRequestToEntity(AppointmentRequest request) {
        User user = RepoHelper.findByIdOrThrow(userRepository, request.userId(), "User", "user id");
        Hospital hospital = RepoHelper.findByIdOrThrow(hospitalRepository, request.hospitalId(), "Hospital", "hospital id");
        Donation donation = RepoHelper.findByIdOrThrow(donationRepository, request.donationId(), "Donation", "donation id");
        BloodRequest bloodRequest = RepoHelper.findByIdOrThrow(bloodRequestRepository, request.bloodRequestId(), "Blood Request", "blood request id");

        return appointmentMapper.toEntity(request, user, hospital, donation, bloodRequest);
    }

    @Override
    protected AppointmentResponse mapEntityToResponse(Appointment entity) {
        return appointmentMapper.toResponse(entity);
    }

    @Override
    protected void updateEntityFromRequest(Appointment entity, AppointmentRequest request) {
        User user = RepoHelper.findByIdOrThrow(userRepository, request.userId(), "User", "user id");
        Hospital hospital = RepoHelper.findByIdOrThrow(hospitalRepository, request.hospitalId(), "Hospital", "hospital id");
        Donation donation = RepoHelper.findByIdOrThrow(donationRepository, request.donationId(), "Donation", "donation id");
        BloodRequest bloodRequest = RepoHelper.findByIdOrThrow(bloodRequestRepository, request.bloodRequestId(), "Blood Request", "blood request id");

        appointmentMapper.updateEntity(entity, request, user, hospital, donation, bloodRequest);
    }
}
