package test.sp.iot.anno4;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
@Service
public class GameStage {
	@Autowired
	InputBallNum ibn;
	@Autowired
	BallGame bg;
	
	public static void main(String[] args){
		ApplicationContext factory;
		String path = "classpath:/test.xml";
		factory = new ClassPathXmlApplicationContext(path);
		GameStage gs = (GameStage) factory.getBean("gameStage");;
		gs.ibn.setScanner(new Scanner(System.in));
		gs.bg.makeBallNum();
		while(!gs.bg.getCheck()){
			List<Integer> numList = gs.ibn.inputNumList();
			String result = gs.bg.checkNum(numList);
			System.out.println(result);
		}
		gs.bg.printBallNum();
	}
}
