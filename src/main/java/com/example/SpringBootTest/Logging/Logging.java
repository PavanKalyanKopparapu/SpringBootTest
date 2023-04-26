package com.example.SpringBootTest.Logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class Logging {
    Logger logger = LoggerFactory.getLogger(Logging.class);
    StopWatch stopWatch = new StopWatch();

    @Before(value = "execution(* com.example.SpringBootTest.Service.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        stopWatch.start();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        logger.info("Executing "+className+"."+methodName);
    }

    @After(value = "execution(* com.example.SpringBootTest.Service.*.*(..))")
    public void logAfter(){
        stopWatch.stop();
        logger.info("Time consumed in Nanoseconds: "+stopWatch.getTotalTimeNanos());
        logger.info("Time consumed in Milliseconds: "+stopWatch.getTotalTimeMillis());
    }
}
