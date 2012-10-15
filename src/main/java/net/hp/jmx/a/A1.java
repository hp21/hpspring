package net.hp.jmx.a;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class A1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new A1().run();
	}

	private void run() {

		ApplicationContext context = new ClassPathXmlApplicationContext("jmx.a.xml");
		Person person = context.getBean("hp-person", Person.class);

		System.out.println(person);
		System.out.printf("adult = %b", person.isAdult());

		Scanner in = new Scanner(System.in);
		in.nextLine();

		in.close();

	}

}
