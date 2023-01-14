package com.example.demo.pet;

import com.example.demo.SalesForceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {
    private final SalesForceService sf;

    public PetController(SalesForceService sf) {
        this.sf = sf;
    }
    @GetMapping("pet")
    public ApiPet getPetByName(@RequestParam String name) {
     SfPet p = sf.loadPet("select name_s, godiste from Pet where name= '"+ name +"'");
     ApiPet apiPet = new ApiPet();
//     p.setName(apiPet.getName());
     apiPet.setName(p.getName());
     apiPet.setGodiste(p.getGodiste());
     return  apiPet;
    }
}
