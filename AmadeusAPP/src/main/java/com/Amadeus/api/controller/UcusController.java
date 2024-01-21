package com.Amadeus.api.controller;

import com.Amadeus.api.dto.HavaalanıDTO;
import com.Amadeus.api.dto.UcusDTO;
import com.Amadeus.service.HavaalanıService;
import com.Amadeus.service.UcusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
