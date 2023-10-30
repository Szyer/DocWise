package com.HealthCare.DocWise.Repository;

import com.HealthCare.DocWise.Entity.Keyword;
import com.HealthCare.DocWise.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    Keyword findByKeyword(String keywordName);


}

