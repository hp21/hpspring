package net.hp.jmx.a;

import java.util.Calendar;
import java.util.Date;

public class Person {

	private String name;
	private int age;
	private Date dob;

	public boolean isAdult() {
		Calendar dobCalendar = Calendar.getInstance();
		dobCalendar.setTimeInMillis(dob.getTime());

		return Calendar.getInstance().get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR) > 18;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", dob=" + dob + "]";
	}

}
