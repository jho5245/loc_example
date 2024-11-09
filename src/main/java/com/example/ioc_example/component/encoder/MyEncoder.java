package com.example.ioc_example.component.encoder;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// MyEncoder를 통해 Controller에서 사용하겠다.
// encoder들도 전부 컴포넌트여야 한다.
@Component
public class MyEncoder
{
	private final IEncoder iEncoder;

	// MyEncoder를 Bean에 넣어야 하는데 그러면 생성자의 인자인 Iencoder의 구현체를 넣어야 한다.
	// 근데 BaseEncoder와 WebEncoder가 2개가 있는데 뭘 넣어야 함? 그걸 지정하는 어노테이션이 @Qualifier라는게 있다.
	// 그리하여 하나를 지정해줌으로써 정상적으로 MyEncoder를 Bean에 정상 등록할 수 있다.
	// Qualifier의 name은 변수 이름 지정 방식으로 넣는다.
	public MyEncoder(@Qualifier("webEncoder") IEncoder iEncoder)
	{
		this.iEncoder = iEncoder;
	}

	public String encode(String input)
	{
		return iEncoder.encode(input);
	}
}
