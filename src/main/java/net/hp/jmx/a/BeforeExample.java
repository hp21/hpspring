package net.hp.jmx.a;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeExample {

	@Before("execution(* net.hp.jmx.a.Person.isAdult(..))")
	public void doAccessCheck() {
		System.out.println("Haho");
	}

}