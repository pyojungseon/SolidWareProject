package com.solidware.project.person.service;

import com.solidware.project.person.vo.Group;
import com.solidware.project.person.vo.Person;

public interface PersonService {

	public boolean addPerson(Person person);
	public Person[] getAllPerson();
	public boolean deletePerson(String personName);
	public Group[] getRandom(int groupSize, int sizeLimit);
	
}
