package com.HealthCare.DocWise.Service;

import com.HealthCare.DocWise.DTO.PatientLoginRequest;
import com.HealthCare.DocWise.Entity.Doctor;
import com.HealthCare.DocWise.Entity.Patient;
import com.HealthCare.DocWise.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;
    @Override
    public Patient registerPatient(Patient patient) {
        patient.setDoctors(new ArrayList<>());
        return patientRepository.save(patient);
    }

    public boolean verifyLoginCredentials(PatientLoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Optional<Patient> optionalPatient = patientRepository.findByUsername(username);


        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            String storedPassword = patient.getPassword();
            return password.equals(storedPassword);
        }
        return false;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

}
