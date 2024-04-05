package ru.boyurig.myFirstSpringProject.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.boyurig.myFirstSpringProject.profile.Engine;

@Component
@Profile("prod")
public class ProdEngine implements Engine{
    public ProdEngine(){
        System.out.println("Автомобиль запущен на сервере");
    }

    @Override
    public String go() {
        return "Поехали быстро";
    }
}
