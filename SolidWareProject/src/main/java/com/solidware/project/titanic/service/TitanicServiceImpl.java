package com.solidware.project.titanic.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.solidware.project.titanic.common.TitanicCommonUtils;
import com.solidware.project.titanic.common.TitanicConstants;
import com.solidware.project.titanic.dao.TitanicDao;
import com.solidware.project.titanic.vo.TitanicMember;

import io.solidware.predfun.Model;
import io.solidware.predfun.ModelFactory;


@Service
public class TitanicServiceImpl implements TitanicService{

	@Autowired
	private TitanicDao titanicDao;
	@Autowired
	private ServletContext servletContext; 
	
	@Override
	public boolean addMember(TitanicMember member) {
		// TODO Auto-generated method stub
		return titanicDao.addMember(member);
	}

	@Override
	public Map<String, Object> getLivePercentExpectation(TitanicMember member) throws IOException {
		// TODO Auto-generated method stub
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("Sex", member.getSex());
		hm.put("Pclass",String.valueOf(member.getPclass()));			//Passenger Class (1 = 1st; 2 = 2nd; 3 = 3rd)
		hm.put("Fare", String.valueOf(member.getFare()));				//Passenger Fare
		hm.put("Embarked", member.getEmbarked());		//Port of Embarkation (C = Cherbourg; Q = Queenstown; S = Southampton)
		hm.put("Parch", String.valueOf(member.getParch()));				//Number of Parents/Children Aboard
		hm.put("Age", String.valueOf(member.getAge()));
		hm.put("Cabin", member.getCabin());				//Cabin 선
		hm.put("Name", member.getName());
		hm.put("PassengerId", member.getPassengerId());
		hm.put("SibSp", String.valueOf(member.getSibSp()));				//Number of Siblings/Spouses Aboard
		
		System.out.println(servletContext.getRealPath("/"));
		
		ClassPathResource resource = new ClassPathResource(TitanicConstants.DLM_PATH);
				
		InputStream fis = new FileInputStream(resource.getFile());
		
		Model model = ModelFactory.loadModel(TitanicConstants.DLM_FILE_NAME, fis);
		Map<String, Object> prediction = model.predict(hm);
		
		System.out.println(prediction.toString());
		System.out.println((double) prediction.get("Survived"));
		return prediction;
	}

	@Override
	public TitanicMember getTitanicMember(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		TitanicMember member = new TitanicMember();
		int parch=0, sibsp=0, survived=2;

		if(TitanicCommonUtils.isEmpty(request.getParameter("Name"))) {
			throw new Exception("Name is empty");
		}
		if(!request.getParameter("Embarked").equals("C") && !request.getParameter("Embarked").contentEquals("Q") 
				&& !request.getParameter("Embarked").contentEquals("S")) {
			throw new Exception("Invalid Value Embarked : "+request.getParameter("Embarked"));
		}
		if(TitanicCommonUtils.isEmpty(request.getParameter("Pclass"))) {
			throw new Exception("Pclass is empty");
		}
		if(!TitanicCommonUtils.isEmpty(request.getParameter("Parch"))) {
			parch=Integer.valueOf(request.getParameter("Parch"));	//invalid value 처리?
		}
		if(!TitanicCommonUtils.isEmpty(request.getParameter("SibSp"))) {
			sibsp=Integer.valueOf(request.getParameter("SibSp"));	//invalid value 처리?
		}
		if(!TitanicCommonUtils.isEmpty(request.getParameter("survived"))) {
			sibsp=Integer.valueOf(request.getParameter("survived"));	//invalid value 처리?
		}
		
		member.setSex(request.getParameter("Sex"));
		member.setPclass(Integer.valueOf(request.getParameter("Pclass")));
		member.setFare(Float.valueOf(request.getParameter("Fare")));
		member.setEmbarked(request.getParameter("Embarked"));
		member.setParch(parch);
		member.setAge(Integer.valueOf(request.getParameter("Age")));
		member.setCabin(request.getParameter("Cabin"));
		member.setName(request.getParameter("Name"));
		member.setPassengerId(request.getParameter("PassengerId"));
		member.setSibSp(sibsp);
		member.setSurvived(survived);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		Date time = new Date();
		member.setRgsDt(format1.format(time));
		member.setSurvived(2);
		return member;
	}

}
