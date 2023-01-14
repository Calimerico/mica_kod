package com.example.demo;

import com.example.demo.pet.SfPet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class CarController {

    @GetMapping("automobili")
    public void method(@RequestParam String cenaOd, @RequestParam String cenaDo) {
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person();
        p1.setFirstName("Pera");
        p1.setLastName("Peric");
        Person p2 = new Person();
        p2.setFirstName("Mika");
        p2.setLastName("Mikic");
        personList.add(p1);
        personList.add(p2);
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < personList.size(); i++) {
            Person person = personList.get(i);
            strings.add(person.getFirstName() +" "+ person.getLastName());

        }
        List<Pravougaonik> pravougaonikList = new ArrayList<>();
        Pravougaonik pravougaonik1 = new Pravougaonik();
        pravougaonik1.setDuzina(5);
        pravougaonik1.setSirina(8);
        Pravougaonik pravougaonik2 = new Pravougaonik();
        pravougaonik2.setDuzina(3);
        pravougaonik2.setSirina(9);
        pravougaonikList.add(pravougaonik1);
        pravougaonikList.add(pravougaonik2);


        List<Integer> povrsine = new ArrayList<>();
        for (int i = 0; i < pravougaonikList.size(); i++) {
            Pravougaonik pravougaonik = pravougaonikList.get(i);
           int povrsina = pravougaonik.getDuzina() * pravougaonik.getSirina();
           if (povrsina > 30) {
               povrsine.add(povrsina);
           }
        }

        List<Integer> povrsineNovNacin = pravougaonikList
                .stream()
                .map(pravougaonik -> {
                    return pravougaonik.getDuzina() * pravougaonik.getSirina();
                }).filter(povrsina -> {
                    return povrsina > 30;
                }).toList();







        SalesForceService sl = new SalesForceService();
        Person person = sl.loadPerson("select firstname from Person where id='55'");
        System.out.println(person.getFirstName());

        List<Person> list = sl.loadPersons("select firstname from Person where age>18");
        for (int i=0; i<list.size(); i++){
//            Person p1 = list.get(i);
//            System.out.println(p1.getFirstName());
        }

    }

    @PostMapping(value = "automobili", consumes = "application/json")
    public void dodajAuto(@RequestBody Car c) {
        System.out.println(c.godiste + c.marka);

        SfPet sfPet = new SfPet();
        sfPet.setName("Megi");
        System.out.println(sfPet.getName());
        String name= sfPet.getName();
        System.out.println(name);

    }

    @GetMapping("urlPrimer/{ime}")
    public String method2(@PathVariable String ime) {
        log.info("izvrsava se metoda sa parametrom ime:" + ime);
        Person p = null;
        try {
            p.getLastName();
        } catch (NullPointerException e) {
            System.out.println("desila se greska");
        }
        System.out.println("pera");
        try {
            method23("gfgf");
        } catch (FileNotFoundException e) {
            log.error("desila se greska");
        }
        System.out.println("jjj");
        return ime;
    }

    @GetMapping("urlPrimer2")
    public void method23(@RequestHeader String imeHeadera) throws FileNotFoundException {
        Person p = null;
        p.getLastName();
        System.out.println(imeHeadera);
    }

    @PostMapping("drugiUrl")
    public void method1() {
        System.out.println("ova ispisuje post");
    }
}
