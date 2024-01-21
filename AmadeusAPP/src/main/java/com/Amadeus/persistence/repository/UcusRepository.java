package com.Amadeus.persistence.repository;

import com.Amadeus.persistence.entity.Havaalanı;
import com.Amadeus.persistence.entity.Ucus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface UcusRepository extends JpaRepository<Ucus,Long> {
    @Query(value="SELECT * FROM amadeus.ucus where havaalanı_kalkis_id=?1 and havaalanı_varıs_id=?2 and kalkıs_tarih >= ?3 order by kalkıs_tarih" ,nativeQuery = true)
    List<Ucus> findSearched(Long kalkisId, Long varisId, LocalDateTime kalkisTarih);


}


