package com.Amadeus.persistence.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "havaalanı")

public class Havaalanı {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sehir",nullable = false)
    private String sehir;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
}
