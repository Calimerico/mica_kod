package com.example.demo;

import com.example.demo.pet.ApiPet;
import com.example.demo.pet.PetController;
import com.example.demo.pet.SfPet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class PetControllerTest {

    SalesForceService salesForceService = Mockito.mock(SalesForceService.class);
    @Test
    public void test() {
        SfPet sfPet = new SfPet();
        sfPet.setName("Megi");
        sfPet.setGodiste(2011);
        Mockito.when(salesForceService.loadPet("select name_s, godiste from Pet where name= 'Megi'")).thenReturn(sfPet);
        PetController petController = new PetController(salesForceService);
        ApiPet megi = petController.getPetByName("Megi");
        Assertions.assertThat(megi.getName()).isEqualTo("Megi");
        Assertions.assertThat(megi.getGodiste()).isEqualTo(2011);
    }
}
