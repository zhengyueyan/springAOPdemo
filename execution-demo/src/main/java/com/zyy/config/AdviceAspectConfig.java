package com.zyy.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Before("matchAnno()")
 * @After("matchAnno())") //相当于finally
 * @AfterReturning("matchException()")
 * @AfterThrowing("matchException()")
 * @Around("matchException()")
 * @Before(value = "matchLongArg() && args(productId)")
 * public void beforeWithArgs(Long productId)
 * @AfterReturning(value = "matchReturn()",returning = "returnValue")
 * public void getReulst(Object returnValue)
 * Created by cat on 2017-02-19.
 */
@Aspect
@Component
public class AdviceAspectConfig {

    /******pointcut********/

    @Pointcut("@annotation(com.zyy.anno.AdminOnly) && within(com.zyy..*)")
    public void matchAnno(){}

    @Pointcut("execution(* *..find*(Long)) && within(com.zyy..*) ")
    public void matchLongArg(){}

    @Pointcut("execution(public * com.zyy.service..*Service.*(..) throws java.lang.IllegalAccessException) && within(com.zyy..*)")
    public void matchException(){}

    @Pointcut("execution(String com.zyy..*.*(..)) && within(com.zyy..*)")
    public void matchReturn(){}

    @Before("matchAnno()")
    public void checkAdmin(ProceedingJoinPoint joinPoint){

    }

    /******advice********/
    @Before("matchLongArg() && args(productId)")
    public void before(Long productId){
        System.out.println("###before,get args:"+productId);
    }

    @Around("matchException()")
    public java.lang.Object after(ProceedingJoinPoint joinPoint){
        System.out.println("###before");
        java.lang.Object result = null;
        try{
            result = joinPoint.proceed(joinPoint.getArgs());
            System.out.println("###after returning");
        }catch (Throwable e){
            System.out.println("###ex");
            //throw
            e.printStackTrace();
        }finally {
            System.out.println("###finally");
        }
        return result;
    }

}
