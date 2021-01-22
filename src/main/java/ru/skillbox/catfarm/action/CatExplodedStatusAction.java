package ru.skillbox.catfarm.action;

import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.ChangeStatusAction;
import ru.skillbox.catfarm.model.CatStatus;

@Component
public class CatExplodedStatusAction extends ChangeStatusAction {

    @Override
    public CatStatus getDestinationStatus() {
        return CatStatus.EXPLODED;
    }

    @Override
    public void execute(AbstractCat cat) {
        context.removeDeadCat(cat);
    }
}
