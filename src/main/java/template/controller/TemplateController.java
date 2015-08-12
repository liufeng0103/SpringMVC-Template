package template.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import template.model.Greeting;
import template.service.GreetingService;

@Controller
@RequestMapping("/hello")
public class TemplateController {
	
	private static Logger log = LoggerFactory.getLogger(TemplateController.class);
	
	private GreetingService greetingService;
	
	@Autowired
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	/**
	 * 根据配置的ViewResolver， 通过返回的字符串，spring会去找/WEB-INF/jsps下的home.jsp 
	 */
	@RequestMapping("/mvc")
	public String helloMVC() {
		return "home";
	}
	
	// 处理/hello/greeting?id=123的get请求
	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String greeting(@RequestParam("id") Integer id, Model model) {
		log.debug("In greeting, id={}", id);
		Greeting greeting = greetingService.getGreeting(id);
		model.addAttribute(greeting);
		return "greeting";
	}

	// 处理restful风格的/hello/greeting/123的get请求
	@RequestMapping(value="/greeting/{id}", method=RequestMethod.GET)
	public String greeting2(@PathVariable("id") Integer id, Map<String, Object> model) {
		log.debug("In greeting2, id={}", id);
		Greeting greeting = greetingService.getGreeting(id);
		model.put("greeting", greeting);
		return "greeting";
	}
}
