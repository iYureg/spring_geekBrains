package ru.boyurig.myFirstSpringProject.model;


import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.boyurig.myFirstSpringProject.profile.Engine;

@Component
@Profile("local")
public class LocalEngine implements Engine {
    public LocalEngine(){
        System.out.println("Двигатель запущен на локальной машине");
    }

    @Override
    public String go(){
        return "Автомобиль поехал медленно...";
    }
}
