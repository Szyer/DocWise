package com.HealthCare.DocWise.Controller;

import com.HealthCare.DocWise.DTO.DoctorRegistrationRequest;
import com.HealthCare.DocWise.DTO.KeywordSearchRequest;
import com.HealthCare.DocWise.Entity.Doctor;
import com.HealthCare.DocWise.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/register")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorRegistrationRequest doctorRegistrationRequest) {
        try {
            Doctor doctor = doctorService.registerDoctor(doctorRegistrationRequest);
            return ResponseEntity.ok("Doctor Registered");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @PostMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctorsByKeyword(@RequestBody KeywordSearchRequest keywordSearchRequest) {
        String keyword = keywordSearchRequest.getKeyword();
        List<Doctor> doctors = doctorService.findDoctorsByKeyword(keyword);
        if (doctors.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(doctors);
        }
    }

    @GetMapping("/getDoctors")
        public ResponseEntity<List<Doctor>> getAllDoctors() {
            List<Doctor> doctors = doctorService.getAllDoctors();
            if (doctors.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(doctors);
            }
    }

    @PostMapping("/book-appointment")
    public ResponseEntity<String> bookAppointment(@RequestParam Long doctorId, @RequestParam Long patientId) {
        if (doctorService.bookAppointment(doctorId, patientId)) {
            return ResponseEntity.ok("Appointment booked successfully.");
        } else {
            return ResponseEntity.badRequest().body("Appointment booking failed.");
        }
    }
}