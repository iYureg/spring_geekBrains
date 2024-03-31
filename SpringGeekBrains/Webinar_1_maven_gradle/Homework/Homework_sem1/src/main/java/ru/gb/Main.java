package ru.gb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.gb.gson.PersonDeserializer;
import ru.gb.model.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Иван", "Иванов", 30);

        // to json
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(person);
        System.out.println(json);

        // back to object
        gson = new GsonBuilder()
                .registerTypeAdapter(Person.class, new PersonDeserializer())
                .create();

        Person personFromJson = gson.fromJson(json, Person.class);
        System.out.println(personFromJson);

    }
}