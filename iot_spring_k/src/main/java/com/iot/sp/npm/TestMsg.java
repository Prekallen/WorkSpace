package com.iot.sp.npm;

public class TestMsg implements IPrintMsg{
	public void hello() {
		System.out.println("test aop");
		
	}
	public void hello2() {
		System.out.println("test AOP");
		
	}
	@Override
	public void hello3() {
		System.out.println("test AOP");
	}
}
