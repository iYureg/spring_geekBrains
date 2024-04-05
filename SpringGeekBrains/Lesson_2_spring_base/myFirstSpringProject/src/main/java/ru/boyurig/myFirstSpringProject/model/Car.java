package ru.boyurig.myFirstSpringProject.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.boyurig.myFirstSpringProject.profile.Engine;

@Service
public class Car {
    @Autowired
    Engine engine;

    public String start(){
        return engine.go();
    }


}
