package com.solidware.project.titanic.common;

public class TitanicCommonUtils {

	public static boolean isEmpty(String str) {
		
		if(str==null) return true;
		if(str.length()==0) return true;
		
		return false;
	}
}
