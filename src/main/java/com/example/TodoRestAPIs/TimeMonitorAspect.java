package com.example.TodoRestAPIs;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {
    @Around("@annotation(TimeMonitor)")
    public void logTime(ProceedingJoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try{
            joinPoint.proceed();
        }  catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            long end = System.currentTimeMillis();

            long totalExecutionTime = end- start;
            System.out.println("Time of execution : " + totalExecutionTime);
        }

    }
}
