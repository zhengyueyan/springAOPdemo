package com.zyy.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * //匹配方法标注有AdminOnly的注解的方法
 * @Pointcut("@annotation(com.zyy.anno.AdminOnly) && within(com.zyy..*)")
 * //匹配标注有NeedSecured的类底下的方法 //class级别
 * @Pointcut("@within(com.zyy.anno.NeedSecured) && within(com.zyy..*)")
 * //匹配标注有NeedSecured的类及其子类的方法 //runtime级别
 * 在spring context的环境下,二者没有区别
 * @Pointcut("@target(com.zyy.anno.NeedSecured) && within(com.zyy..*)")
 * //匹配传入的参数类标注有Repository注解的方法
 * @Pointcut("@args(com.zyy.anno.NeedSecured) && within(com.zyy..*)")
 * Created by cat on 2016-12-04.
 */
@Aspect
@Component
public class AnnoAspectConfig {

    @Pointcut("@args(com.zyy.anno.NeedSecured) && within(com.zyy..*)")
    public void matchAnno(){}

    @Before("matchAnno()")
    public void before(){
        System.out.println("");
        System.out.println("###before");
    }

}
