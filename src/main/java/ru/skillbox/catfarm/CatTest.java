package ru.skillbox.catfarm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.AbstractCatFactory;
import ru.skillbox.catfarm.api.GlobalCatFarmContext;
import ru.skillbox.catfarm.model.CatStatus;

@Component
@RequiredArgsConstructor
public class CatTest {

    private final CatCreator catCreator;
    private final GlobalCatFarmContext context;

    public void startTest() {

        AbstractCat cat1 = catCreator.getCat();
        AbstractCat cat2 = catCreator.getCat();
        AbstractCat cat3 = catCreator.getCat();
        System.out.println("Cat status " + cat1.getStatus());
        System.out.println("Cat count before = " + context.getCatCount());
        while (CatStatus.isALive(cat1.getStatus())) {
            cat1.feed(100.0);
            cat1.drink(50);
        }
        System.out.println("Cat food " + context.getFoodEaten(cat1));
        System.out.println("Cat weight " + cat1.getWeight());
        System.out.println("Cat count after = " + context.getCatCount());

    }
}
