package ru.skillbox.catfarm.api;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public abstract class AbstractCat {

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double status;

    @LifecycleSupported
    public abstract void meow();

    @LifecycleSupported
    public abstract void feed(double foodAmount);

    public abstract void drink(double foodAmount);

    public abstract void pee(double seconds);

}
