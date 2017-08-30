package test.sp.iot.anno3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Execute {
	
	@Autowired
	UserService us;
	public static void main(String []args){
		ApplicationContext factory;
		String path = "classpath:/test2.xml";
		factory = new ClassPathXmlApplicationContext(path);
		Execute e = (Execute) factory.getBean("execute");
		System.out.println(e);
		User user = (User) factory.getBean("user");
		System.out.println(e.us.login(user));
		
	}
}
