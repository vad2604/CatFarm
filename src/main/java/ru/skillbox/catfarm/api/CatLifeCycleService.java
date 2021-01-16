package ru.skillbox.catfarm.api;

import ru.skillbox.catfarm.model.CatStatus;

public interface CatLifeCycleService {

    void changeStatus(CatStatus destinationStatus);

}
