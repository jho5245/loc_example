package com.example.ioc_example.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

// 일반 클래스에서 Bean을 주입하는 방법 - ApplicationContext의 도움이 필요
// 컴포넌트가 아닌 클래스에서 Bean을 사용하기 위해서 필요한 클래스( 해당 클래스에 주입 없이)
// Provider 클래스느 자체는 컴포넌트가 되어야 App context를 주입받을 수 있다.
// 다른 클래스에서 해당 클래스는 @Component나 @Autowired 없이 Bean을 getBean 메소드를 통해 가져와서 쓸 수 있다.
@Component
public class ApplicationContextProvider implements ApplicationContextAware
{
	// context는 하나만 있어야 하기 때문에 static 사용
	private static ApplicationContext applicationContext;

	// API로 제공되기 때문에 @Autowired 등을 사용하면 안됨 (알아서 주입됨)
	@Override
	public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException
	{
		ApplicationContextProvider.applicationContext = applicationContext;
	}

	// component가 아닌 bean을 가져오기 위해서 이름을 집어넣으면 app context를 통해 bean을 찾아 사용하는 곳에 넘겨줌
	// context를 직접 던지는 것은 무겁기 때문에 static을 통해 바로 bean을 get할 수 있도록 메소드를 선언
	/**
	 * bean getter
	 * @param clazz the class
	 * @return instance related to the class
	 */
	public static <T> T getBean(Class<T> clazz)
	{
		return applicationContext.getBean(clazz);
	}
}
