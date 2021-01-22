package ru.skillbox.catfarm.action;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.Cat;
import ru.skillbox.catfarm.api.AbstractCat;
import ru.skillbox.catfarm.api.ChangeStatusAction;
import ru.skillbox.catfarm.api.ChangeStatusActionExecutor;
import ru.skillbox.catfarm.model.CatStatus;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChangeStatusActionExecutorImpl implements ChangeStatusActionExecutor {

    private final List<ChangeStatusAction> actions;

    @Override
    public void executeAction(AbstractCat cat, CatStatus destinationStatus) {
         actions.stream()
                 .filter(action -> action.getDestinationStatus().equals(destinationStatus))
                 .forEach(action -> action.execute(cat));
    }
}
