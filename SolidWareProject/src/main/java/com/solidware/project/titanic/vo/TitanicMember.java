package com.solidware.project.titanic.vo;

public class TitanicMember {

	private String Sex;
	private String Pclass;			//Passenger Class (1 = 1st; 2 = 2nd; 3 = 3rd)
	private String Fare;			//Passenger Fare
	private String Embarked;		//Port of Embarkation (C = Cherbourg; Q = Queenstown; S = Southampton)
	private String Parch;			//Number of Parents/Children Aboard
	private String Age;
	private String Cabin;			//Cabin
	private String Name;
	private String PassengerId;
	private String SibSp;			//Number of Siblings/Spouses Aboard
	
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getPclass() {
		return Pclass;
	}
	public void setPclass(String pclass) {
		Pclass = pclass;
	}
	public String getFare() {
		return Fare;
	}
	public void setFare(String fare) {
		Fare = fare;
	}
	public String getEmbarked() {
		return Embarked;
	}
	public void setEmbarked(String embarked) {
		Embarked = embarked;
	}
	public String getParch() {
		return Parch;
	}
	public void setParch(String parch) {
		Parch = parch;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getCabin() {
		return Cabin;
	}
	public void setCabin(String cabin) {
		Cabin = cabin;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassengerId() {
		return PassengerId;
	}
	public void setPassengerId(String passengerId) {
		PassengerId = passengerId;
	}
	public String getSibSp() {
		return SibSp;
	}
	public void setSibSp(String sibSp) {
		SibSp = sibSp;
	}
	
	
}
