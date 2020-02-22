package com.am.mapstruct.mapper;

import com.am.mapstruct.dto.PersonDTO;
import com.am.mapstruct.model.Person;
import com.am.mapstruct.utils.IterableUtils;
import com.am.mapstruct.utils.OnlyFirstElement;
import com.am.mapstruct.utils.PersonListMapping;
import com.am.mapstruct.utils.PersonMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = IterableUtils.class)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    //model to dto

    @PersonMapping
    @Mappings({
        @Mapping(source = "name", target = "personName"),
        @Mapping(source = "surname", target = "personSurname"),
        @Mapping(source = "emails", target = "email", qualifiedBy = OnlyFirstElement.class),
    })
    PersonDTO modelToDto(Person model);

    @PersonListMapping
    @IterableMapping(qualifiedBy = PersonMapping.class)
    List<PersonDTO> modelListToDto(List<Person> models);

}
