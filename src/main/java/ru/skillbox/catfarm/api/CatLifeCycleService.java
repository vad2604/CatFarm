package ru.skillbox.catfarm.api;

import ru.skillbox.catfarm.Cat;
import ru.skillbox.catfarm.model.CatStatus;

public interface CatLifeCycleService {

    void changeStatus(AbstractCat cat, CatStatus destinationStatus);

}
