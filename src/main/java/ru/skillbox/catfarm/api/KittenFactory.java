package ru.skillbox.catfarm.api;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.Kitten;
import ru.skillbox.catfarm.api.AbstractCatFactory;

@Component
public class KittenFactory extends AbstractCatFactory<Kitten> {

    @Override
    public Kitten doCreate() {
        return objectFactory.getObject();
    }
}
