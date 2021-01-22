package ru.skillbox.catfarm.api;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.model.CatColor;
import ru.skillbox.catfarm.model.CatStatus;

import java.util.UUID;

@Data
@Component
@Scope("prototype")
public abstract class AbstractCat {

    protected String id;

    protected double originWeight;

    protected double weight;

    @Value("${cat.minweight}")
    protected double minWeight;

    @Value("${cat.maxweight}")
    protected double maxWeight;

    private CatStatus status;
    private CatColor color;

    public AbstractCat() {
        this.id = UUID.randomUUID().toString();
    }

    @LifecycleSupported
    public void meow() {
        weight = weight - 1;
    }

    @LifecycleSupported
    @FoodCount
    public void feed(double amount) {
        weight = weight + amount;
    }

    @LifecycleSupported
    public void drink(double amount) {
        weight = weight + amount;
    }

    @LifecycleSupported
    public void pee(double seconds) {
        weight -= seconds;
    }
}
