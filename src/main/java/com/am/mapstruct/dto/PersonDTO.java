package com.am.mapstruct.dto;

import lombok.Data;

@Data
public class PersonDTO {

    private String personName;
    private String personSurname;
    private String email; //only the first email in list

}
