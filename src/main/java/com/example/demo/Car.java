package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    @JsonProperty("marka_c")
    String marka;
    int godiste;

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }
}
