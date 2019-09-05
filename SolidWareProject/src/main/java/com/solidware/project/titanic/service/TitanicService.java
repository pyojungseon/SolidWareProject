package com.solidware.project.titanic.service;

import java.io.IOException;
import java.util.Map;

import com.solidware.project.titanic.vo.TitanicMember;

public interface TitanicService {

	public boolean addPerson(TitanicMember member);
	public Map<String, Object> getLivePercentExpectation(TitanicMember member) throws IOException;
	
}
