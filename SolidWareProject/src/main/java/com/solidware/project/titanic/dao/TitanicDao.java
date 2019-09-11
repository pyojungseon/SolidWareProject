package com.solidware.project.titanic.dao;

import com.solidware.project.titanic.vo.TitanicMember;

public interface TitanicDao {

	public int getNextSeqNumber();
	public boolean addMember(TitanicMember member);
	public boolean updateSurvived(TitanicMember member);
}
