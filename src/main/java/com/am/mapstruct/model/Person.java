package com.am.mapstruct.model;

import lombok.Data;

import java.util.List;

@Data
public class Person {

    private String name;
    private String surname;

    private List<String> emails;

}
