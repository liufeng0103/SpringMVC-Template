package template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import template.dao.GreetingDao;
import template.model.Greeting;
import template.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	private GreetingDao greetingDao;
	
	@Autowired
	public void setGreetingDao(GreetingDao greetingDao) {
		this.greetingDao = greetingDao;
	}

	@Override
	public Greeting getGreeting(int id) {
		return greetingDao.getGreeting(id);
	}

}
