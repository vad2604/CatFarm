package ru.skillbox.catfarm;

import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCatFactory;

@Component
public class CatFactoryImpl extends AbstractCatFactory<Cat> {


    @Override
    public Cat createCat() {
        return objectFactory.getObject();
    }
}
