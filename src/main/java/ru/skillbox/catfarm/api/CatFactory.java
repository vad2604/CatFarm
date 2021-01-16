package ru.skillbox.catfarm.api;

public interface CatFactory {

    AbstractCat createCat();

    AbstractCat createKitten();
}
