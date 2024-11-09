package com.example.ioc_example.dto;

import com.example.ioc_example.component.ApplicationContextProvider;
import com.example.ioc_example.component.encoder.BaseEncoder;
import com.example.ioc_example.component.encoder.IEncoder;
import com.example.ioc_example.component.encoder.MyEncoder;

public class MessageConvertDto
{
	private String message;

	public MessageConvertDto()
	{
	}

	private MessageConvertDto(Builder builder)
	{
		this.message = builder.message;
	}

	public String getMessage()
	{
		// Bean을통해 Encoder를 가져와야 하는데 Autowired 등 1번 방법이 아닌 app context provider 활용
		// dto는 spring boundary 외의 클래스이기 때문에 주입 방식으로 객체를 가져올 수 없다.
		//IEncoder encoder = ApplicationContextProvider.getBean(BaseEncoder.class);
		// MyEncoder라는 컴포넌트가 Bean에 저장되어 있기 때문에 provider를 통해 myencoder를 가져온다. (MyEncoder는 Qualifier가 Web 기반이다)
		var encoder = ApplicationContextProvider.getBean(MyEncoder.class);
		return encoder.encode(message);
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public static Builder builder()
	{
		return new Builder();
	}

	public static class Builder
	{
		private String message;

		public Builder message(String message)
		{
			this.message = message;
			return this;
		}

		public MessageConvertDto build()
		{
			return new MessageConvertDto(this);
		}
	}
}
