package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OsiguranikController {
    private final SalesForceService sf;
    private final SQLService sqlService;

    public OsiguranikController(SalesForceService sf, SQLService sqlService) {
        this.sf = sf;
        this.sqlService = sqlService;
    }

    @GetMapping("osiguranje")
    public Integer izracunajOsiguranje(@RequestParam int jmbg, @RequestParam String tablice) {
        String tipOsiguranja = sf
                .getTipOsiguranja("select tipOsiguranja from Osiguranje where tablica_c='"+ tablice +"'");

        Integer iznos = sqlService.getIznosStete(tipOsiguranja);
        Integer brojPrestupa = sqlService.getBrojPrestupa(jmbg);
        return iznos - brojPrestupa * 1000;
    }

}
