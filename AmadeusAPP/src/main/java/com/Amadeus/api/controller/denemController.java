package com.Amadeus.api.controller;

import com.Amadeus.api.dto.HavaalanıDTO;
import com.Amadeus.api.dto.UcusDTO;
import com.Amadeus.persistence.entity.Havaalanı;
import com.Amadeus.persistence.entity.Ucus;
import com.Amadeus.persistence.repository.HavaalanıRepository;
import com.Amadeus.persistence.repository.UcusRepository;
import com.Amadeus.service.HavaalanıService;
import com.Amadeus.service.UcusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class denemController {
    HavaalanıService havaalanıService;
    UcusService ucusService;


    @Autowired
    denemController(HavaalanıService havaalanıService,UcusService ucusService){
        this.havaalanıService = havaalanıService;
        this.ucusService =ucusService;
    }


    @GetMapping("/kkkkkkkkkkkkkkkkkkkkkkkkkkk")
    public List<HavaalanıDTO> getAllHavaalanı(){
        return  havaalanıService.allhavaalanı();
    }

    @GetMapping("/uckkkkkkkkkkkkkkkkkkkkuslar")
    public List<UcusDTO> getallUcus(){
        return  ucusService.getAllUcus();
    }



}
