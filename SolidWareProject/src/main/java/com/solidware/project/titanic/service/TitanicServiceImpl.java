package com.solidware.project.titanic.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.solidware.project.titanic.vo.TitanicMember;

import io.solidware.predfun.Model;
import io.solidware.predfun.ModelFactory;


@Service
public class TitanicServiceImpl implements TitanicService{

	//@Autowired
	//private TitanicDao titanicDao;
	@Autowired
	private ServletContext servletContext; 
	
	@Override
	public boolean addPerson(TitanicMember member) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Map<String, Object> getLivePercentExpectation(TitanicMember member) throws IOException {
		// TODO Auto-generated method stub
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("Sex", member.getSex());
		hm.put("Pclass", member.getPclass());			//Passenger Class (1 = 1st; 2 = 2nd; 3 = 3rd)
		hm.put("Fare", member.getFare());				//Passenger Fare
		hm.put("Embarked", member.getEmbarked());		//Port of Embarkation (C = Cherbourg; Q = Queenstown; S = Southampton)
		hm.put("Parch", member.getParch());				//Number of Parents/Children Aboard
		hm.put("Age", member.getAge());
		hm.put("Cabin", member.getCabin());				//Cabin 선
		hm.put("Name", member.getName());
		hm.put("PassengerId", member.getPassengerId());
		hm.put("SibSp", member.getSibSp());				//Number of Siblings/Spouses Aboard
		
		System.out.println(servletContext.getRealPath("/"));
		
		ClassPathResource resource = new ClassPathResource("model/titanic.dlm");
		
		
		InputStream is = new FileInputStream(resource.getFile());
		
		Model model = ModelFactory.loadModel("titanic.dlm", is);
		Map<String, Object> prediction = model.predict(hm);
		
		System.out.println(prediction.toString());
		System.out.println((double) prediction.get("Survived"));
		return prediction;
	}
}
