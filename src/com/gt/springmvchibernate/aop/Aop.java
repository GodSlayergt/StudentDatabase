package com.gt.springmvchibernate.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop {
	
	@Pointcut("execution(* com.gt.springmvchibernate.dao.DAOImp.*(..))")
	private void pointcut() {};
	
	@Before("pointcut()")
	public void before(JoinPoint jp)
	{
		System.out.println("======>Staring to Execute<=======");
		System.out.println(" ====>" +jp.getSignature().toString() +"<=========");
		
		
	}
	
	@AfterReturning(pointcut = "pointcut()",returning="result")
	public void before(JoinPoint jp,Object result)
	{
		System.out.println(" ====>" +jp.getSignature().toString() +"<=========");
		System.out.println("======>Ended<=======");
		System.out.println("======>result<=======");
		if(result!=null)
		System.out.println("======>"+ result.toString()  + "<=======");		
	}
	
	
	@AfterThrowing(pointcut = "pointcut()",throwing="exc")
	public void before(JoinPoint jp,Throwable exc)
	{
		System.out.println(" ====>" +jp.getSignature().toString() +"<=========");
		System.out.println("======>Thrown an Exception<=======");
		System.out.println("======>"+ exc.getMessage()  + "<=======");
		
	}

}
