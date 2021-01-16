package ru.skillbox.catfarm.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.skillbox.catfarm.api.CatLifeCycleService;
import ru.skillbox.catfarm.model.CatStatus;

@Component
public class CatLifeCycleServiceImpl implements CatLifeCycleService {

    @Override
    @Transactional
    public void changeStatus(CatStatus destinationStatus) {

    }
}
