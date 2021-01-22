package ru.skillbox.catfarm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;

@Component
@Scope("prototype")
public class Kitten extends AbstractCat {

    @Value("${cat.kittenweight}")
    private double kittenWeight;

    public Kitten() {
        super();
        this.weight = kittenWeight;
        this.originWeight = weight;
    }
}
