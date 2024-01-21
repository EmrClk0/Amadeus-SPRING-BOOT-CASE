package com.Amadeus.api.controller;


import com.Amadeus.api.dto.HavaalanıDTO;
import com.Amadeus.api.dto.UcusDTO;
import com.Amadeus.service.HavaalanıService;
import com.Amadeus.service.UcusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/havaalani")
public class HavaalanıController {

    HavaalanıService havaalanıService;

    @Autowired
    HavaalanıController(HavaalanıService havaalanıService){
        this.havaalanıService = havaalanıService;
    }


    @GetMapping("/all")
    public List<HavaalanıDTO> getAllHavaalanı(){
        return  havaalanıService.allhavaalanı();
    }

    @PostMapping("/save")
    public ResponseEntity<HavaalanıDTO> addHavaalanı(@RequestBody HavaalanıDTO havaalanıDTO){
        HavaalanıDTO savedDto = this.havaalanıService.save(havaalanıDTO);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    /*  //HAVAALANI FOREGİNKEY OLDUGU İÇİN SİLİNMEMELİ
    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<String> deleteHavaalanı (@PathVariable("itemId") Long id){

        try {
            this.havaalanıService.delete(id);
            return ResponseEntity.ok("Havaalanı deleted successfully!");
        } catch (Exception e) {
            // Silme işlemi başarısız olduysa, INTERNAL_SERVER_ERROR yanıtı ve hata mesajını gönder
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Havaalanı deletion failed: " + e.getMessage());
        }
    }
    */

    @PutMapping("/update/{id}")
    public HavaalanıDTO updateHavaalanı(@PathVariable Long id, @RequestBody HavaalanıDTO havaalanıDTO) {

        System.out.println("update controller");
        return this.havaalanıService.update(id,havaalanıDTO);

    }
}
