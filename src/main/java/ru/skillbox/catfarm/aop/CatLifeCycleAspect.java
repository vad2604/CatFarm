package ru.skillbox.catfarm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CatLifeCycleAspect {

    public CatLifeCycleAspect() {
        System.out.println("aspect created");
    }

    @After("@annotation(ru.skillbox.catfarm.api.LifecycleSupported)")
    public void logExecutionTime(JoinPoint joinPoint) throws Throwable {
        //AbstractCat cat = (AbstractCat) instance;
        //System.out.println(cat.getWeight());
        System.out.println("catch!");
        //joinPoint.proceed();
        System.out.println("catch!");

        //System.out.println(cat.getWeight());
    }

    @Pointcut("execution(* ru.skillbox.catfarm.Cat.*(..))")
    public void pointCut() {
    }
}
