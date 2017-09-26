package com.iot.sp.npm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[]args){
//		IPrintMsg target = new IPrintMsgImp();
//		// Proxy 빈껍데기 생성
//		ProxyFactory pf = new ProxyFactory();
//		pf.addAdvice(new MyAroundAdvice());	// 충고 add
//		pf.setTarget(target);	//타겟 add
//		IPrintMsg proxy = (IPrintMsg) pf.getProxy();
//		
//		proxy.hello();
//		proxy.hello2();
//		proxy.hello3();
		
		ApplicationContext at = new ClassPathXmlApplicationContext("aop/ioc.xml");
		IPrintMsg printMsg = (IPrintMsg)at.getBean("testMsg");
		printMsg.hello();
	}
}
