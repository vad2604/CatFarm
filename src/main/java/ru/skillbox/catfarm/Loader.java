package ru.skillbox.catfarm;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
@Configuration
@PropertySource("classpath:config.properties")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Loader {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext =
                new AnnotationConfigApplicationContext(Loader.class);
        CatTest catTest = applicationContext.getBean(CatTest.class);
        Cat cat = applicationContext.getBean(Cat.class);
        catTest.startTest();
    }
}
