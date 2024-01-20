package com.Amadeus.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="ucus")
public class Ucus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kalkıs_tarih", columnDefinition = "DATETIME")
    private LocalDateTime  kalkısTarih;

    @Column(name = "dönüs_tarih", columnDefinition = "DATETIME")
    private LocalDateTime dönüsTarih;

    @ManyToOne()
    @JoinColumn(name = "havaalanı_kalkis_id", referencedColumnName = "id")
    private Havaalanı kalkıs;

    @ManyToOne()
    @JoinColumn(name = "havaalanı_varıs_id", referencedColumnName = "id")
    private Havaalanı varıs;

    @Column(name = "fiyat")
    private Double fiyat;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getKalkısTarih() {
        return kalkısTarih;
    }

    public void setKalkısTarih(LocalDateTime kalkısTarih) {
        this.kalkısTarih = kalkısTarih;
    }

    public LocalDateTime getDönüsTarih() {
        return dönüsTarih;
    }

    public void setDönüsTarih(LocalDateTime dönüsTarih) {
        this.dönüsTarih = dönüsTarih;
    }

    public Havaalanı getKalkıs() {
        return kalkıs;
    }

    public void setKalkıs(Havaalanı kalkıs) {
        this.kalkıs = kalkıs;
    }

    public Havaalanı getVarıs() {
        return varıs;
    }

    public void setVarıs(Havaalanı varıs) {
        this.varıs = varıs;
    }

    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }
}
