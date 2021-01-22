package ru.skillbox.catfarm.action;

import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.Cat;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.ChangeStatusAction;
import ru.skillbox.catfarm.model.CatStatus;

import java.util.Arrays;
import java.util.List;

@Component
public class DeadCatStatusAction extends ChangeStatusAction {

    @Override
    public CatStatus getDestinationStatus() {
        return CatStatus.DEAD;
    }

    @Override
    public void execute(AbstractCat cat) {
        context.removeDeadCat(cat);
    }
}
