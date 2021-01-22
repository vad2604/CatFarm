package ru.skillbox.catfarm.api;

import ru.skillbox.catfarm.Cat;
import ru.skillbox.catfarm.model.CatStatus;

public interface ChangeStatusActionExecutor {

    void executeAction(AbstractCat cat, CatStatus destinationStatus);
}
