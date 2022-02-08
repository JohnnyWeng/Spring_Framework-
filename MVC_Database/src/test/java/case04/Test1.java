package case04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.Spring.case04.mvc.controller.UserController;
import com.study.Spring.case04.mvc.entity.User;


public class Test1 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext4.xml");
		
		UserController userController = ctx.getBean(UserController.class);
		System.out.println(userController);
		userController.create(new User("John", 20)); // (Controller -> Service -> DAO -> DB)
		
		System.out.println(userController.queryUsers());
		
		((ClassPathXmlApplicationContext)ctx).close();
	}
}







 







 
