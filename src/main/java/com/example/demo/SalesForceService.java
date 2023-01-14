package com.example.demo;

import com.example.demo.pet.SfPet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesForceService {
    public Person loadPerson(String query) {
        return null;
    }
    public List<Person> loadPersons(String query) {
        return null;
    }
    public SfPet loadPet(String query) {
        SfPet sfPet = new SfPet();
        sfPet.setName("Dzeki");
        sfPet.setGodiste(2015);
        return  sfPet;
    }
    public String getTipOsiguranja(String query) {
        return "zlatno";
    }

}
