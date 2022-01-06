package com.libraryproject.libraryproject.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.libraryproject.libraryproject.service.*.*(..))")
    public void beforeMessage(JoinPoint joinPoint){
        System.out.println("before aspect çalıştı "+joinPoint.getArgs());
    }
    @After("execution(* com.libraryproject.libraryproject.service.*.*(..))")
    public  void  afterMessage(JoinPoint joinPoint){
        System.out.println("after aspect çalıştı "+joinPoint.getArgs());

    }
}
