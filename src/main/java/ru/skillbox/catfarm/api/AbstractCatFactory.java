package ru.skillbox.catfarm.api;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.skillbox.catfarm.Cat;
import ru.skillbox.catfarm.model.CatStatus;

@Component
public abstract class AbstractCatFactory<T extends AbstractCat> {

    @Autowired
    private CatLifeCycleService lifeCycleService;

    @Autowired
    protected ObjectFactory<T> objectFactory;

    public T createCat() {
        T cat = doCreate();
        executePostCreateActions(cat);
        return cat;
    }

    private void executePostCreateActions(T cat) {
        lifeCycleService.changeStatus(cat, CatStatus.PLAYING);
    }


    protected abstract T doCreate();
}
