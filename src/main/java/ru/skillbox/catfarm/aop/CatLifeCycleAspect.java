package ru.skillbox.catfarm.aop;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.Cat;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.CatLifeCycleService;
import ru.skillbox.catfarm.model.CatStatus;

@Aspect
@Component
@RequiredArgsConstructor
public class CatLifeCycleAspect {

    @Value("${cat.minweight}")
    protected double minWeight;

    @Value("${cat.maxweight}")
    protected double maxWeight;

    private final CatLifeCycleService lifeCycleService;

    @Around("@annotation(ru.skillbox.catfarm.api.LifecycleSupported)")
    public void logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        AbstractCat abstractCat = (AbstractCat) joinPoint.getTarget();
        Double weightBefore = abstractCat.getWeight();
        if (CatStatus.isALive(abstractCat.getStatus())) {
            joinPoint.proceed();
            resolveStatus(abstractCat, weightBefore);
        }
    }

    private void resolveStatus(AbstractCat cat, Double weightBefore) {
        Double weightAfter = cat.getWeight();
        Double originWeight = cat.getOriginWeight();
        if (weightAfter < minWeight) {
            lifeCycleService.changeStatus(cat, CatStatus.DEAD);
        }
        else if (weightAfter > maxWeight) {
            lifeCycleService.changeStatus(cat, CatStatus.EXPLODED);
        }
        else if (weightAfter > originWeight && CatStatus.PLAYING != cat.getStatus()) {
            lifeCycleService.changeStatus(cat, CatStatus.PLAYING);
        }
    }

}
