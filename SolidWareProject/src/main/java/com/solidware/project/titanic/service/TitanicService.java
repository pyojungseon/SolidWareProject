package com.solidware.project.titanic.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.solidware.project.titanic.vo.TitanicMember;

public interface TitanicService {

	public boolean addMember(TitanicMember member);
	public Map<String, Object> getLivePercentExpectation(TitanicMember member) throws IOException;
	public TitanicMember getTitanicMember(HttpServletRequest request) throws Exception;
	
}
