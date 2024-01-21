package com.Amadeus.persistence.repository;

import com.Amadeus.persistence.entity.Havaalanı;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HavaalanıRepository extends JpaRepository<Havaalanı,Long> {
    List<Havaalanı> findBySehir(String sehir);
}
