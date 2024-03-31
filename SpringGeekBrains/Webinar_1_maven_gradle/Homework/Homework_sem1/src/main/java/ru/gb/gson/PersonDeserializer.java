package ru.gb.gson;

import com.google.gson.*;
import ru.gb.model.Person;

import java.lang.reflect.Type;

public class PersonDeserializer implements JsonDeserializer {

    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Person person = new Person();
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        person.setFirstName(jsonObject.get("name").getAsString());
        person.setAge(jsonObject.get("age").getAsInt());
        person.setLastName(jsonObject.get("surname").getAsString());
        return person;
    }
}
