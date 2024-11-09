package com.example.ioc_example.controller;

import com.example.ioc_example.component.HelloService;
import com.example.ioc_example.dto.MessageConvertDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/hello")
@RestController
public class HelloController
{
	// 1. Autowired로 주입받기
	// HelloService도 미리 Bean(Component)화가 되어 있어야 주입할 수 있다.
	// 따라서 new로 초기화하지 않아도 사용할 수 있다.
	//@Autowired
	//private HelloService helloService;



	// 2. setter function
	// setter 메소드에 @Autowired를 사용한다.
//	private HelloService helloService;
//	@Autowired
//	public void setHelloService(HelloService helloService) // 함수 이름을 필드명과 관련된 setter 규칙과 동일하게 지정해야한다. (그래야 스프링이 찾을 수 있음)
//	{
//		this.helloService = helloService;
//	}
	
	
	
	// 3. constructor function(권장)
	// HelloController를 생성하려면 이 생성자 호출이 강제적이기 때문에 Autowired가 필요없다 (붙여도 오류는 안남)
	private final HelloService helloService;
	public HelloController(HelloService helloService)
	{
		this.helloService = helloService;
	}
	

	@GetMapping(path = "/name")
	public String findUserByQueryParam(@RequestParam String name)
	{
		return helloService.hello(name);
	}

	@GetMapping(path ="/message")
	public ResponseEntity<?> encodeClientMessage(@RequestParam String message)
	{
		var messageConvert = MessageConvertDto.builder().message(message).build();
		return ResponseEntity.ok(messageConvert);
	}
}
