package ru.skillbox.catfarm.api;

import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.Cat;
import ru.skillbox.catfarm.model.CatInfo;
import ru.skillbox.catfarm.model.CatStatus;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class GlobalCatFarmContext {

    private Map<String, CatInfo> allCats = new HashMap<>();
    private Set<String> activeCats = new HashSet<>();

    public void addNewCat(AbstractCat cat) {
        allCats.put(cat.getId(), new CatInfo(cat.getStatus(), 0.0));
        activeCats.add(cat.getId());
    }

    public int getCatCount() {
        return activeCats.size();
    }

    public void countEatenFood(AbstractCat cat, double newFoodEaten) {
        CatInfo catInfo = allCats.get(cat.getId());
        catInfo.setFoodEaten(catInfo.getFoodEaten() + newFoodEaten);
    }

    public Double getFoodEaten(AbstractCat cat) {
        return allCats.get(cat.getId()).getFoodEaten();
    }

    public void removeDeadCat(AbstractCat cat) {
        activeCats.remove(cat.getId());
    }

}
