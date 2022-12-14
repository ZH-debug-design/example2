package com.ZH.community;

import com.ZH.community.service.ServiceZH;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes=CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	@Test
	public  void  testApplicationContext(){
		System.out.println(applicationContext);
		ServiceZH a=applicationContext.getBean(ServiceZH.class);
		ServiceZH b=applicationContext.getBean(ServiceZH.class);
	}

	@Test
	public  void  testBean(){
		SimpleDateFormat s=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(s.format(new Date()));
	}
}
