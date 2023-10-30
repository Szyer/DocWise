package com.HealthCare.DocWise.Service;

import com.HealthCare.DocWise.DTO.DoctorRegistrationRequest;
import com.HealthCare.DocWise.Entity.Appointment;
import com.HealthCare.DocWise.Entity.Doctor;
import com.HealthCare.DocWise.Entity.Keyword;
import com.HealthCare.DocWise.Entity.Patient;
import com.HealthCare.DocWise.Repository.AppointmentRepository;
import com.HealthCare.DocWise.Repository.DoctorRepository;
import com.HealthCare.DocWise.Repository.KeywordRepository;
import com.HealthCare.DocWise.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final KeywordRepository keywordRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    @Override
    public Doctor registerDoctor(DoctorRegistrationRequest doctorRegistrationRequest) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorRegistrationRequest.getName());
        doctor.setEmail(doctorRegistrationRequest.getEmail());
        doctor.setSpecialization(doctorRegistrationRequest.getSpecialization());
        List<String> keywordNames = doctorRegistrationRequest.getKeywords();
        List<Keyword> keywords = new ArrayList<>();

        for (String keywordName : keywordNames) {
            Keyword keyword = keywordRepository.findByKeyword(keywordName);
            if (keyword == null) {
                keyword = new Keyword(keywordName);
                keywordRepository.save(keyword);
            }
            keywords.add(keyword);
        }

        doctor.setKeywords(keywords);
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findDoctorsByKeyword(String keyword) {
        Keyword keywordName = keywordRepository.findByKeyword(keyword);
        if(keyword==null){
            return new ArrayList<>();
        }
        List<Doctor>doctors = keywordName.getDoctors();
        return doctors;
    }

    @Transactional
    @Override
    public boolean bookAppointment(Long doctorId, Long patientId) {

        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        Patient patient = patientRepository.findById(patientId).orElse(null);

        if (doctor != null && patient != null) {

            Appointment appointment = new Appointment();
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            appointment.setAppointmentTime(LocalDateTime.now());


            appointmentRepository.save(appointment);
            patient.addDoctor(doctor);
            doctor.addPatient(patient);

            return true;
        }

        return false;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

}

