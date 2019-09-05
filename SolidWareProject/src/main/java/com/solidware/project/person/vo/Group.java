package com.solidware.project.person.vo;

public class Group {

	private String name;
	private Person[] persons;
	
	//Default Constructor block
	private Group() {
	}
	
	public Group(String _name) {
		this.name=_name;

	}
	
	public String getName() {
		return name;
	}
	
	public Person[] getPersons() {
		return persons;
	}

	public void setPersons(Person[] persons) {
		this.persons = persons;
	}
	

}
