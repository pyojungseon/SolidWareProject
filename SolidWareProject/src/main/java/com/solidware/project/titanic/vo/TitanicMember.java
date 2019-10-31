package com.solidware.project.titanic.vo;

public class TitanicMember {

	private int seq;
	private String sex;
	private int pclass;			//Passenger Class (1 = 1st; 2 = 2nd; 3 = 3rd)
	private float fare;			//Passenger Fare
	private String embarked;		//Port of Embarkation (C = Cherbourg; Q = Queenstown; S = Southampton)
	private int parch;			//Number of Parents/Children Aboard
	private int age;
	private String cabin;			//Cabin
	private String name;
	private String passengerId;
	private int sibSp;			//Number of Siblings/Spouses Aboard
	private int survived;		//1 = Survived ; 0 = Dead; 2 = No result
	private String rgsDt;
	private String rgsTs;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getPclass() {
		return pclass;
	}
	public void setPclass(int pclass) {
		this.pclass = pclass;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}
	public String getEmbarked() {
		return embarked;
	}
	public void setEmbarked(String embarked) {
		this.embarked = embarked;
	}
	public int getParch() {
		return parch;
	}
	public void setParch(int parch) {
		this.parch = parch;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public int getSibSp() {
		return sibSp;
	}
	public void setSibSp(int sibSp) {
		this.sibSp = sibSp;
	}
	public int getSurvived() {
		return survived;
	}
	public void setSurvived(int survived) {
		this.survived = survived;
	}
	public String getRgsDt() {
		return rgsDt;
	}
	public void setRgsDt(String rgsDt) {
		this.rgsDt = rgsDt;
	}
	public String getRgsTs() {
		return rgsTs;
	}
	public void setRgsTs(String rgsTs) {
		this.rgsTs = rgsTs;
	}
	
}
