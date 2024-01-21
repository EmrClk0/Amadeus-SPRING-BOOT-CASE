package com.Amadeus.service;


import com.Amadeus.api.dto.HavaalanıDTO;
import com.Amadeus.api.dto.UcusDTO;
import com.Amadeus.persistence.entity.Havaalanı;
import com.Amadeus.persistence.entity.Ucus;
import com.Amadeus.persistence.repository.HavaalanıRepository;
import com.Amadeus.persistence.repository.UcusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class UcusService {

    private UcusRepository ucusRepository;

    UcusService(UcusRepository ucusRepository){
        this.ucusRepository = ucusRepository;
    }

    public List<UcusDTO> getAllUcus(){
        List<Ucus> allUcus = this.ucusRepository.findAll();
        return  listMapToDTO(allUcus);
    }

    public UcusDTO save(UcusDTO ucusDTO) {
        Ucus ucus = DTOtoUcus(ucusDTO);
        Ucus saved = this.ucusRepository.save(ucus);
        UcusDTO savedDto = mapToDTO(saved);
        return  savedDto;

    }

    public void delete(Long id){
        this.ucusRepository.deleteById(id);
    }

    public UcusDTO update(Long id, UcusDTO ucusDTO){
        Ucus existingUcus = this.ucusRepository.getReferenceById(id);
        Ucus mappedDTO = DTOtoUcus(ucusDTO);
        existingUcus.setKalkıs(mappedDTO.getKalkıs());
        existingUcus.setVarıs(mappedDTO.getVarıs());
        existingUcus.setFiyat(mappedDTO.getFiyat());
        existingUcus.setKalkısTarih(mappedDTO.getKalkısTarih());
        existingUcus.setDönüsTarih(mappedDTO.getDönüsTarih());

        UcusDTO savedDTO = mapToDTO(this.ucusRepository.save(existingUcus));
        return savedDTO;
    }

    @Autowired
    private HavaalanıRepository havaalanıRepository;
    private Ucus DTOtoUcus(UcusDTO ucusDTO) {

        Ucus newUcus = new Ucus();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime kalkıs = LocalDateTime.parse(ucusDTO.getKalkısTarih(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        newUcus.setKalkısTarih(kalkıs);
        LocalDateTime donus = LocalDateTime.parse(ucusDTO.getDönüsTarih(), formatter);
        newUcus.setDönüsTarih(donus);
        newUcus.setFiyat(ucusDTO.getFiyat());


        newUcus.setKalkıs(this.havaalanıRepository.findBySehir(ucusDTO.getKalkısHavaalanı()).get(0));
        newUcus.setVarıs(this.havaalanıRepository.findBySehir(ucusDTO.getVarısHavaalanı()).get(0));





        return newUcus;
    }


    private List<UcusDTO> listMapToDTO(List<Ucus> ucuslar){
        Iterator<Ucus> iterator = ucuslar.iterator();
        List<UcusDTO> ucusDTOS = new ArrayList<>();

        while(iterator.hasNext()){
            Ucus ucus = iterator.next();
            ucusDTOS.add(mapToDTO(ucus));
        }
        return ucusDTOS;
    }

    private UcusDTO mapToDTO(Ucus ucus){
        UcusDTO ucusDTO = new UcusDTO();
        ucusDTO.setKalkısHavaalanı(ucus.getKalkıs().getSehir());
        ucusDTO.setVarısHavaalanı(ucus.getVarıs().getSehir());
        ucusDTO.setFiyat(ucus.getFiyat());

        ucusDTO.setKalkısTarih(ucus.getKalkısTarih());
        ucusDTO.setDönüsTarih(ucus.getDönüsTarih());

        return ucusDTO;
    }



}
