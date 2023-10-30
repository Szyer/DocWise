package com.HealthCare.DocWise.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Keyword(String keyword) {
        this.keyword = keyword;
    }

    private String keyword;

    @ManyToMany(mappedBy = "keywords")
    @JsonIgnore
    private List<Doctor> doctors;


}
