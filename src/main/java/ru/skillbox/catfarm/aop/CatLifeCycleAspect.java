package ru.skillbox.catfarm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;

@Aspect
@Component
public class CatLifeCycleAspect {

    public CatLifeCycleAspect() {
        System.out.println("aspect created");
    }

    @After("@annotation(LifecycleSupported)")
    public void logExecutionTime(JoinPoint joinPoint) throws Throwable {
        //AbstractCat cat = (AbstractCat) instance;
        //System.out.println(cat.getWeight());
        System.out.println("catch!");
        //joinPoint.proceed();
        System.out.println("catch!");

        throw new RuntimeException();
        //System.out.println(cat.getWeight());
    }

    @Pointcut("execution(* ru.skillbox.catfarm.Cat.*(..))")
    public void pointCut() {
    }
}
