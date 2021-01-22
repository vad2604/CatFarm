package ru.skillbox.catfarm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.AbstractCatFactory;

@Component
@RequiredArgsConstructor
public class CatCreator {

    private final AbstractCatFactory<Cat> catFactory;
    private final AbstractCatFactory<Kitten> kittenFactory;

    public Cat getCat() {
        return catFactory.createCat();
    }

    public Kitten getKitten() {
        return kittenFactory.createCat();
    }
}
