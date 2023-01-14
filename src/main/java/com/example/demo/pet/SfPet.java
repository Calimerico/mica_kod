package com.example.demo.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SfPet {
    @JsonProperty("name_s")
    private String name;
    private Integer godiste;
}
