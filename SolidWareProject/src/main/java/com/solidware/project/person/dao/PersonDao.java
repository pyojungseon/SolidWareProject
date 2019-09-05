package com.solidware.project.person.dao;

import com.solidware.project.person.vo.Person;

public interface PersonDao {

	public Person[] getAllPerson();
	
	public boolean addPerson(Person person);
	
	public boolean deletePerson(String personName);
}
