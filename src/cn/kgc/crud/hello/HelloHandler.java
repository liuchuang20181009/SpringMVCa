package cn.kgc.crud.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloHandler {

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		
		System.out.println("hello。。。。。");
		return "ok";
	}
	
}
