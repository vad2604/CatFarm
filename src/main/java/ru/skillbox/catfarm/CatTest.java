package ru.skillbox.catfarm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.CatFactory;

@Component
@RequiredArgsConstructor
public class CatTest {

    private final CatFactory catFactory;

    public void startTest() {

        AbstractCat cat1 = catFactory.createCat();
        cat1.meow();
        cat1.feed(1.0);
    }
}
