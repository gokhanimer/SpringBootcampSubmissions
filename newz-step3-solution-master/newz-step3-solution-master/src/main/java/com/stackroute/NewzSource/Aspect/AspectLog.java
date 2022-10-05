package com.stackroute.NewzSource.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.stackroute.NewzSource.model.NewsSource;

@Component
@Aspect
public class AspectLog {

	Logger logger=LoggerFactory.getLogger(AspectLog.class);
	
	@Before("execution(* com.stackroute.NewzSource.controller.NewsSourceController.saveNews(..))")
	public void beforeAdd(JoinPoint jp)
	{
		logger.info("Before saving news source");
	}
	@Around("execution(* com.stackroute.NewzSource.controller.NewsSourceController.getNews(..))")
		public Object gettingNews(ProceedingJoinPoint pjp) throws Throwable
	{
		Object o = pjp.proceed();
		try
		{
			ResponseEntity r =(ResponseEntity) o;
			
			NewsSource nso = (NewsSource) r.getBody();
			System.out.println("News Source Id: " + nso.getNewssourceId()
					+ "News Source Name :" + nso.getNewssourceName()
					+ "News Source Desc :" + nso.getNewssourceDesc()
					+ "News Source CreatedBy :" + nso.getNewssourceCreatedBy() );
		}
		catch(Exception e) {
			System.out.println("Not able to get news");
		}
		return o;
		
	}
	
	@Around("execution(* com.stackroute.NewzSource.controller.NewsSourceController.saveNews(..))")
	public Object duringAdd(ProceedingJoinPoint pjp) throws Throwable
	{
		Object o = pjp.proceed();
		try {
			ResponseEntity r =(ResponseEntity) o;
			
			NewsSource nso = (NewsSource) r.getBody();
			System.out.println("news added");
		}catch(Exception e){
			System.out.println("not able to add news");
		}
		return o;
	}
	
	@After("execution(* com.stackroute.NewzSource.controller.NewsSourceController.saveNews(..))")
	public void afterAdd(JoinPoint jp)
	{
		System.out.println("News source saved!");
	}
	@After("execution(* com.stackroute.NewzSource.controller.NewsSourceController.updateNews(..))")
	public void afterUpdate(JoinPoint jp) 
	{
		System.out.println("News source updated!");
	}
	
}
