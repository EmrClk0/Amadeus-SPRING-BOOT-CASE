package com.Amadeus.api.dto;

import com.Amadeus.persistence.entity.Havaalanı;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UcusDTO {

    private DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern(
            "yyyy-MM-dd HH:mm:ss");

    private String kalkısTarih;
    private String dönüsTarih;
    private String kalkısHavaalanı;
    private String varısHavaalanı;
    private Double fiyat;

    public String getKalkısTarih() {
        return kalkısTarih;
    }

    public void setKalkısTarih(LocalDateTime kalkısTarih) {
        this.kalkısTarih = kalkısTarih.format(formatter);
    }

    public String getDönüsTarih() {
        return dönüsTarih;
    }

    public void setDönüsTarih(LocalDateTime dönüsTarih) {
        this.dönüsTarih = dönüsTarih.format(formatter);
    }

    public String getKalkısHavaalanı() {
        return kalkısHavaalanı;
    }

    public void setKalkısHavaalanı(String kalkısHavaalanı) {
        this.kalkısHavaalanı = kalkısHavaalanı;
    }

    public String getVarısHavaalanı() {
        return varısHavaalanı;
    }

    public void setVarısHavaalanı(String varısHavaalanı) {
        this.varısHavaalanı = varısHavaalanı;
    }

    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }
}
