package com.example.ioc_example.component.encoder;

// 얘는 구현체가 아니기 때문에 @Component를 넣으면 안된다
public interface IEncoder
{
	String encode(String input);
}
