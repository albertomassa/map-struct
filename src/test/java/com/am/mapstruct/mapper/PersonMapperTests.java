package com.am.mapstruct.mapper;

import com.am.mapstruct.dto.PersonDTO;
import com.am.mapstruct.mapstruct.MapStructApplication;
import com.am.mapstruct.model.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MapStructApplication.class)
class PersonMapperTests {

	private PersonMapper mapper;

	@Test
	public void testModelToDto() {
		Person person = this.fillPerson("john", "doe");
		PersonDTO personDTO = mapper.INSTANCE.modelToDto(person);

		Assert.assertNotNull(personDTO);
		Assert.assertEquals(person.getName(), personDTO.getPersonName());
		Assert.assertEquals(person.getSurname(), personDTO.getPersonSurname());
		Assert.assertEquals(person.getEmails().get(0), personDTO.getEmail());
	}

	@Test
	public void testModelListToDto() {
		List<Person> people = new ArrayList<>();
		people.add(this.fillPerson("john", "doe"));
		people.add(this.fillPerson("albert", "smith"));
		List<PersonDTO> peopleDTO = mapper.INSTANCE.modelListToDto(people);

		Assert.assertNotNull(peopleDTO);
		Assert.assertEquals(people.size(), peopleDTO.size());
	}

	private Person fillPerson(String name, String surname) {
		Person person = new Person();
		person.setName(name);
		person.setSurname(surname);
		List<String> emails = new ArrayList<>();
		emails.add(name + "." + surname + "@first.com");
		emails.add(name + "." + surname + "@second.com");
		person.setEmails(emails);
		return person;
	}


}
