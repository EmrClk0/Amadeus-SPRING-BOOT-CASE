package com.Amadeus.persistence.repository;

import com.Amadeus.persistence.entity.Havaalanı;
import com.Amadeus.persistence.entity.Ucus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UcusRepository extends JpaRepository<Ucus,Long> {

}


