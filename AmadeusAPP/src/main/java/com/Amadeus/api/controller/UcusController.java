package com.Amadeus.api.controller;

import com.Amadeus.api.dto.UcusDTO;
import com.Amadeus.persistence.entity.Ucus;
import com.Amadeus.service.UcusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/ucus")
public class UcusController {

    UcusService ucusService;

    @Autowired
    UcusController(UcusService ucusService){
        this.ucusService =ucusService;
    }

    @GetMapping("/all")
    public List<UcusDTO> getallUcus(){

        System.out.println("başlıyoruz");
        return  ucusService.getAllUcus();
    }


    @PostMapping("/save")
    public ResponseEntity<UcusDTO> addUcus(@RequestBody UcusDTO ucusDTO){

        UcusDTO savedDto = this.ucusService.save(ucusDTO);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<String> deleteUcus(@PathVariable("itemId") Long id){

        try {
            this.ucusService.delete(id);
            return ResponseEntity.ok("UCUS deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("UCUS deletion failed: " + e.getMessage());
        }
    }


    @PutMapping("/update/{id}")
    public UcusDTO updateUcus(@PathVariable Long id, @RequestBody UcusDTO ucusDTO) {
        
        return this.ucusService.update(id,ucusDTO);

    }



    @GetMapping("/search")
    public HashMap<String, List<Ucus>> searchUcuslar(
            @RequestParam("kalkisSehir") String kalkisSehir,
            @RequestParam(value = "varisSehir") String varisSehir,
            @RequestParam("kalkisTarih") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime kalkisTarih,
            @RequestParam(value = "donusTarih", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime donusTarih) {

        return this.ucusService.search(kalkisSehir,varisSehir,kalkisTarih,donusTarih);

    }




}
