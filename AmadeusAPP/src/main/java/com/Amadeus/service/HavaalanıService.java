package com.Amadeus.service;


import com.Amadeus.api.dto.HavaalanıDTO;
import com.Amadeus.api.dto.UcusDTO;
import com.Amadeus.persistence.entity.Havaalanı;
import com.Amadeus.persistence.entity.Ucus;
import com.Amadeus.persistence.repository.HavaalanıRepository;
import org.hibernate.jdbc.Expectation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class HavaalanıService {

    private HavaalanıRepository havaalanıRepository;


    HavaalanıService(HavaalanıRepository havaalanıRepository){
        this.havaalanıRepository=havaalanıRepository;
    }

    public List<HavaalanıDTO> allhavaalanı(){
        List<Havaalanı> allhavaalanı = this.havaalanıRepository.findAll();
        return listMapToDTO(allhavaalanı);
    }

    public HavaalanıDTO save(HavaalanıDTO havaalanıDTO){
        Havaalanı havaalanı = DTOtoHavaalanı(havaalanıDTO);
        Havaalanı saved = this.havaalanıRepository.save(havaalanı);
        HavaalanıDTO savedDto = mapToDTO(saved);
        return  savedDto;

    }

    public void  delete(Long id){
        this.havaalanıRepository.deleteById(id);
    }

    public HavaalanıDTO update(Long id, HavaalanıDTO havaalanıDTO) {
        Havaalanı existingHavaalanı = null;

        try {
            existingHavaalanı = havaalanıRepository.findById(id).orElseThrow(() -> new Exception("Havaalanı not found "));
            existingHavaalanı.setSehir(havaalanıDTO.getSehir());
            return mapToDTO(this.havaalanıRepository.save(existingHavaalanı));
        } catch (Exception e) {

        }


        havaalanıDTO.setSehir("the city is not in database ");
        return havaalanıDTO;
    }






    private List<HavaalanıDTO> listMapToDTO(List<Havaalanı> havaalanları){
        Iterator<Havaalanı> iterator = havaalanları.iterator();
        List<HavaalanıDTO> havaalanıDTOS = new ArrayList<>();
        while(iterator.hasNext()){
            Havaalanı havaalanı = iterator.next();
            havaalanıDTOS.add(mapToDTO(havaalanı));
        }
        return havaalanıDTOS;

    }

    private HavaalanıDTO mapToDTO(Havaalanı havaalanı){
        HavaalanıDTO havaalanıDTO = new HavaalanıDTO();
        havaalanıDTO.setSehir(havaalanı.getSehir());
        return  havaalanıDTO;
    }

    private Havaalanı DTOtoHavaalanı(HavaalanıDTO havaalanıDTO){
        Havaalanı newHavaalanı = new Havaalanı();
        newHavaalanı.setSehir(havaalanıDTO.getSehir());
        return newHavaalanı;
    }



}
