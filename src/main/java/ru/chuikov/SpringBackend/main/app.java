package ru.chuikov.SpringBackend.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.chuikov.SpringBackend.config.MainConfig;
import ru.chuikov.SpringBackend.entity.test;
import ru.chuikov.SpringBackend.services.TestService;

public class app {
	public static AnnotationConfigApplicationContext ctx;

	public static void main(String[] args) {
		System.out.println("Start app");

		ctx = new AnnotationConfigApplicationContext();
		ctx.register(MainConfig.class);
		ctx.refresh();
		new app();
	}

	public app() {

		TestService service = (TestService) ctx.getBean("testServiceImpl");
		
		// Test insert
		service.insert(new test("helo1", 50));
		service.insert(new test("helo2", 100));
		service.insert(new test("helo3", 70));
		service.insert(new test("helo4", 100));
		service.insert(new test("helo5", 50));
		service.insert(new test("helo6", 50));
		
		// Test findUniqueBy
		System.out.println("findUniqueBy");
		System.out.println(service.findUniqueBy("tstring", "helo3").toString());
		
		// Test findBy
		System.out.println("findBy");
		for (test test : service.findBy("tint", 100)) {
			System.out.println(test.toString());
		}
		
		// Test findByIDs
		System.out.println("findByIDs");
		for (test test : service.getByIds("1 3 5")) {
			System.out.println(test.toString());
		}
		//Test update
		System.out.println(service.findUniqueBy("stroka", "helo2"));
		test t = service.findUniqueBy("id", (long) 1);
		t.setTint(t.getTint() + 500);
		t.setTstring("new str");
		service.update(t);
		System.out.println(service.findUniqueBy("id", (long) 1));
	}

}
