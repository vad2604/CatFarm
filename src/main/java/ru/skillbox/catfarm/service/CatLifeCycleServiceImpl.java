package ru.skillbox.catfarm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.skillbox.catfarm.Cat;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.CatLifeCycleService;
import ru.skillbox.catfarm.api.ChangeStatusActionExecutor;
import ru.skillbox.catfarm.model.CatStatus;

@Component
@RequiredArgsConstructor
public class CatLifeCycleServiceImpl implements CatLifeCycleService {

    private final ChangeStatusActionExecutor actionExecutor;

    @Override
    @Transactional
    public void changeStatus(AbstractCat cat, CatStatus destinationStatus) {
        actionExecutor.executeAction(cat, destinationStatus);
        cat.setStatus(destinationStatus);
    }
}
