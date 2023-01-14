package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Person {
   @JsonProperty("firstname_c")
   private String firstName;

   String lastName;



}
