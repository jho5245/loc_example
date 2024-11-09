package com.example.ioc_example.component.encoder;

import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
//@Component(value = "bb") 해당 클래스가 빈에 등록될때 적용할 이름 설정 - 일반적으로 클래스 명의 변수명 지정 방식(webEncoder로 등록됨)
public class WebEncoder implements IEncoder
{
	@Override
	public String encode(String input)
	{
		return URLEncoder.encode(input, StandardCharsets.UTF_8);
	}
}
