package com.Amadeus.api.controller;

import com.Amadeus.persistence.entity.Havaalanı;
import com.Amadeus.persistence.entity.Ucus;
import com.Amadeus.persistence.repository.HavaalanıRepository;
import com.Amadeus.persistence.repository.UcusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class denemController {
    HavaalanıRepository havaalanıRepository;
    UcusRepository ucusRepository;

    @Autowired
    denemController(HavaalanıRepository havaalanıRepository,UcusRepository ucusRepository){
        this.havaalanıRepository = havaalanıRepository;
        this.ucusRepository = ucusRepository;
    }


    @GetMapping("/havaalanları")
    public List<Havaalanı> getAllHavaalanı(){
        List<Havaalanı> all = this.havaalanıRepository.findAll();
        return all;
    }

    @GetMapping("/ucuslar")
    public List<Ucus> getAllUcus(){
        List<Ucus> all = this.ucusRepository.findAll();
        return all;

    }
}
