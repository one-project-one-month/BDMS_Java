package com.opom.bdms.repository;

import com.opom.bdms.entity.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Repository interface for Appointment entity.
 */
public interface AppointmentRepository extends BaseRepository<Appointment> {
    boolean existsByHospitalIdAndAppointmentDateAndAppointmentTime(Long hospitalId, LocalDate appointmentDate, LocalTime appointmentTime);

    boolean existsByHospitalIdAndAppointmentDateAndAppointmentTimeAndIdNot(Long hospitalId, LocalDate appointmentDate, LocalTime appointmentTime, Long id);
}
