package ru.skillbox.catfarm.action;

import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.ChangeStatusAction;
import ru.skillbox.catfarm.model.CatStatus;

@Component
public class CatBornStatusAction extends ChangeStatusAction {

    @Override
    public CatStatus getDestinationStatus() {
        return CatStatus.PLAYING;
    }

    @Override
    public void execute(AbstractCat cat) {
        context.addNewCat(cat);
    }
}
