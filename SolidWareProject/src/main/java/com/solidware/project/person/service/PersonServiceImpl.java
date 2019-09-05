package com.solidware.project.person.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solidware.project.person.dao.PersonDao;
import com.solidware.project.person.exception.GroupOutOfBoundException;
import com.solidware.project.person.exception.PersonLengthException;
import com.solidware.project.person.vo.Group;
import com.solidware.project.person.vo.Person;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	public PersonDao personDao;
	
	public boolean addPerson(Person person) {
			
		return personDao.addPerson(person);
	}
	
	public Person[] getAllPerson() {
		
		return personDao.getAllPerson();
	}
	
	public boolean deletePerson(String personName) {
		boolean isDelete=false;
		isDelete = personDao.deletePerson(personName);
		return isDelete;
	}
	
	public Group[] getRandom(int groupSize, int sizeLimit) {
		if(groupSize<0 || sizeLimit<0)
			throw new GroupOutOfBoundException("groupSize : "+groupSize + "|| sizeLimit : "+sizeLimit);
		
		Person[] arrayPerson = personDao.getAllPerson();
		List<Person> list = new ArrayList<>();
		
		for(Person person : arrayPerson) {
			list.add(person);
		}
		
		//CASE! : 사람 숫자보다 그룹의 숫자가 클 경우, 그룹의 숫자를 사람숫자 만큼만 만들기 null그룹 없애기
		/*if(list.size()<=groupSize)
			groupSize=list.size();
		*/
		
		//CASE2 : 최소크기를 먼저 맞추고 남는 그룹은 없애기
		if(list.size()<=sizeLimit*groupSize)
			groupSize=(list.size()/groupSize)+1;
		
		Group[] groups = new Group[groupSize];
		List<Person>[] groupList=new List[groupSize];
		for(int i=0;i<groupSize;i++) {
			groups[i] = new Group(i+1+" Gruop");
			groupList[i] = new ArrayList<Person>();
		}
		
		int usedSize=0;
		SecureRandom sr = new SecureRandom();
		
		//CASE1 : 그룹별로 돌아가며 넣어 최소 크기를 먼저 맞춘다
		/*while(!list.isEmpty() && usedSize<groupSize*sizeLimit) {
			for (int i=0;i<groupSize;i++) {
				if(list.size()==0) break;
				int position = sr.nextInt(list.size());
				groupList[i].add(list.get(position));
				list.remove(position);	
				usedSize++;
			}
		}*/
		
		//CASE2 : 첫번째 그룹에 최소 크기를 먼저 맞춘다.
		while(!list.isEmpty() && usedSize<groupSize*sizeLimit) {
			for (int i=0;i<groupSize;i++) {
				for(int j=0;j<sizeLimit;j++) {
					if(list.size()==0) break;
					int position = sr.nextInt(list.size());
					groupList[i].add(list.get(position));
					list.remove(position);	
					usedSize++;
				}
			}
		}
		
		//최소 크기를 맞춘 후 나머지 그룹화
		while(!list.isEmpty()) {
			int position = sr.nextInt(groupSize);
			groupList[position].add(list.get(list.size()-1));
			list.remove(list.size()-1);
		}
		
		//array에서 list로 return 형식 변경 
		for(int i=0;i<groupSize;i++) {
			List<Person> group = groupList[i];
			Person[] people = new Person[group.size()];
			for(int j=0;j<group.size();j++) {
				people[j]=group.get(j);
			}
			groups[i].setPersons(people);
		}
		
		return groups;
		
	}
}
