package be.mobyus.ie5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.mobyus.ie5.app.EshopApplicationController;

public class SpringRunner {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");

		EshopApplicationController controller = (EshopApplicationController) applicationContext.getBean("EshopApplicationController");
		controller.run();

		applicationContext.close();
	}
}
