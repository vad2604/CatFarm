package ru.skillbox.catfarm;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Loader {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext =
                new AnnotationConfigApplicationContext(Loader.class);
        CatTest catTest = applicationContext.getBean(CatTest.class);
        Cat cat = applicationContext.getBean(Cat.class);
        cat.meow();
        catTest.startTest();
    }
}
