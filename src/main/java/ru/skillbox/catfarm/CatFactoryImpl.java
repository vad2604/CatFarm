package ru.skillbox.catfarm;

import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.CatFactory;

@Component
public class CatFactoryImpl implements CatFactory {

    @Override
    public AbstractCat createCat() {
        return new Cat();
    }

    @Override
    public AbstractCat createKitten() {
        return null;
    }
}
