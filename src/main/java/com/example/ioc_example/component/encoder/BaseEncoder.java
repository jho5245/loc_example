package com.example.ioc_example.component.encoder;

import org.springframework.stereotype.Component;

@Component
public class BaseEncoder implements IEncoder
{
	@Override
	public String encode(String input)
	{
		return java.util.Base64.getEncoder().encodeToString(input.getBytes());
	}
}
