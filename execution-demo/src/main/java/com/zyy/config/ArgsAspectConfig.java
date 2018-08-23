package com.zyy.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * //匹配任何以find开头而且只有一个Long参数的方法
 * @Pointcut("execution(* *..find*(Long))")
 * //匹配任何以find开头的而且第一个参数为Long型的方法
 * @Pointcut("execution(* *..find*(Long,..))")
 * //匹配任何只有一个Long参数的方法
 * @Pointcut("within(com.zyy..*) && args(Long)")
 * //匹配第一个参数为Long型的方法
 * @Pointcut("within(com.zyy..*) && args(Long,..)")
 * Created by cat on 2016-12-04.
 */
@Aspect
@Component
public class ArgsAspectConfig {
//    @Pointcut("args(Long,String) && within(com.zyy.service.*)")
//    public void matchArgs(){}
//
//    @Before("matchArgs()")
//    public void before(){
//        System.out.println("");
//        System.out.println("###before");
//    }
    @Pointcut("args(Long) && within(com.zyy.service.*)")
    public void matchArgs(){}

    @Before("matchArgs()")
    public void matchArgsBefore(){

    }

}
