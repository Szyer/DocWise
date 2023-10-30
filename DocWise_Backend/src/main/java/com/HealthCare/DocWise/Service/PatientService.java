package com.HealthCare.DocWise.Service;

import com.HealthCare.DocWise.DTO.PatientLoginRequest;
import com.HealthCare.DocWise.Entity.Doctor;
import com.HealthCare.DocWise.Entity.Patient;

import java.util.List;

public interface PatientService {
    Patient registerPatient(Patient patient);

    boolean verifyLoginCredentials(PatientLoginRequest patientLoginRequest);

    List<Patient> getAllPatients();
}
