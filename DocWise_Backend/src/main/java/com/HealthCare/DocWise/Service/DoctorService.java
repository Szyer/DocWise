package com.HealthCare.DocWise.Service;

import com.HealthCare.DocWise.DTO.DoctorRegistrationRequest;
import com.HealthCare.DocWise.Entity.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor registerDoctor(DoctorRegistrationRequest doctorRegistrationRequest);

    List<Doctor> findDoctorsByKeyword(String keyword);

    boolean bookAppointment(Long doctorId, Long patientId);

    List<Doctor> getAllDoctors();
}
