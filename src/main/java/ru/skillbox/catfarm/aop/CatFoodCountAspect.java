package ru.skillbox.catfarm.aop;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.GlobalCatFarmContext;
import ru.skillbox.catfarm.model.CatStatus;

@Aspect
@Component
@RequiredArgsConstructor
public class CatFoodCountAspect {

    private final GlobalCatFarmContext context;

    @After("@annotation(ru.skillbox.catfarm.api.FoodCount)")
    public void countFood(JoinPoint joinPoint) throws Throwable {
        AbstractCat abstractCat = (AbstractCat) joinPoint.getTarget();
        Double foodCount = (Double) joinPoint.getArgs()[0];
        context.countEatenFood(abstractCat, foodCount);
    }
}
