package ru.skillbox.catfarm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.model.CatStatus;

import java.util.List;

@Component
public abstract class ChangeStatusAction {

    @Autowired
    protected GlobalCatFarmContext context;

    public abstract CatStatus getDestinationStatus();

    public abstract void execute(AbstractCat cat);
}
