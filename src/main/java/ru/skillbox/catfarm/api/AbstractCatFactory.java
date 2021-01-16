package ru.skillbox.catfarm.api;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractCatFactory<T extends AbstractCat> {

    @Autowired
    protected ObjectFactory<T> objectFactory;

    public abstract T createCat();
}
