package ru.skillbox.catfarm;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import ru.skillbox.catfarm.api.AbstractCat;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Loader {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext =
                new AnnotationConfigApplicationContext(Loader.class);
        CatTest catTest = applicationContext.getBean(CatTest.class);
        catTest.startTest();
    }
}
