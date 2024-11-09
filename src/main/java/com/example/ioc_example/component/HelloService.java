package com.example.ioc_example.component;

import org.springframework.stereotype.Component;

// HelloService를 사용할 때마다 new를 하긴 빡세니까 컴포넌트로 등록한다.
// 컴포넌트로 등록하면 스프링이 init될 때 component들을 찾아서 다 등록한다.
@Component
public class HelloService
{
	public String hello(String name)
	{
		return "Hello " + name + "!";
	}
}
