package ru.skillbox.catfarm.api;

import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.Cat;
import ru.skillbox.catfarm.api.AbstractCatFactory;

@Component
public class CatFactory extends AbstractCatFactory<Cat> {


    @Override
    public Cat doCreate() {
        return objectFactory.getObject();
    }
}
