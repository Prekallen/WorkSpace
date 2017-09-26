package com.iot.sp.npm;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAroundAdvice {
	
	public void setAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("실행전..");
		Object ret = pjp.proceed();
		System.out.println("실행후..");
	}

}
