package ru.skillbox.catfarm;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.LifecycleSupported;
import ru.skillbox.catfarm.model.CatColor;

@Component
@Scope("prototype")
public class Cat extends AbstractCat {

    public Cat() {
        super();
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
    }

}
