package jdbc_day;

import java.util.Date;

public class Student {
	
	private String SNO;
	private String Name;
	private int Age;
	private String College;
	
	
	public String getSNO() {
		return SNO;
	}
	public void setSNO(String sNO) {
		SNO = sNO;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	@Override
	public String toString() {
		return "Student [SNO=" + SNO + ", Name=" + Name + ", Age=" + Age + ", College=" + College + "]";
	}
	

}
