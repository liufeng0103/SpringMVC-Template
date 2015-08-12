package template.dao.impl;

import org.springframework.stereotype.Repository;

import template.dao.GreetingDao;
import template.model.Greeting;

@Repository
public class GreetingDaoImpl implements GreetingDao {

	@Override
	public Greeting getGreeting(int id) {
		Greeting greeting = new Greeting();
		greeting.setId(1);
		greeting.setContent("Hello SpringMVC");
		return greeting;
	}

}
