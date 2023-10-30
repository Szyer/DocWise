package com.HealthCare.DocWise.Controller;

import com.HealthCare.DocWise.DTO.PatientLoginRequest;
import com.HealthCare.DocWise.Entity.Patient;
import com.HealthCare.DocWise.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.registerPatient(patient);
        if (savedPatient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.badRequest().body("failed to register");
        }
    }

    @GetMapping("/getPatients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        if (patients.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(patients);
        }
    }


    @PostMapping("/login")
    public boolean loginPatient(@RequestBody PatientLoginRequest patientLoginRequest) {
        return patientService.verifyLoginCredentials(patientLoginRequest);
    }
}
