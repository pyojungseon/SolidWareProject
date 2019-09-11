package com.solidware.project.titanic.vo;

public class TitanicMember {

	private int Seq;
	private String Sex;
	private int Pclass;			//Passenger Class (1 = 1st; 2 = 2nd; 3 = 3rd)
	private float Fare;			//Passenger Fare
	private String Embarked;		//Port of Embarkation (C = Cherbourg; Q = Queenstown; S = Southampton)
	private int Parch;			//Number of Parents/Children Aboard
	private int Age;
	private String Cabin;			//Cabin
	private String Name;
	private String PassengerId;
	private int SibSp;			//Number of Siblings/Spouses Aboard
	private int Survived;		//1 = Survived ; 0 = Dead; 2 = No result
		
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public int getPclass() {
		return Pclass;
	}
	public void setPclass(int pclass) {
		Pclass = pclass;
	}
	public float getFare() {
		return Fare;
	}
	public void setFare(float fare) {
		Fare = fare;
	}
	public String getEmbarked() {
		return Embarked;
	}
	public void setEmbarked(String embarked) {
		Embarked = embarked;
	}
	public int getParch() {
		return Parch;
	}
	public void setParch(int parch) {
		Parch = parch;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
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
	public int getSibSp() {
		return SibSp;
	}
	public void setSibSp(int sibSp) {
		SibSp = sibSp;
	}
	public int getSurvived() {
		return Survived;
	}
	public void setSurvived(int survived) {
		Survived = survived;
	}
	public int getSeq() {
		return Seq;
	}
	public void setSeq(int seq) {
		Seq = seq;
	}
	
}
