package com.HealthCare.DocWise.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRegistrationRequest {
    private String name;
    private String specialization;
    private String email;
    private List<String> keywords;
}
