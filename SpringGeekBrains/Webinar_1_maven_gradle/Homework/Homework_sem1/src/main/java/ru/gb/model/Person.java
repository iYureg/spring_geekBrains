package ru.gb.model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Person {
    @SerializedName("name")
    private String firstName;
    @SerializedName("surname")
    private String lastName;
    @SerializedName("age")
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
    }

    // переопределение toString() с использованием библиотеки commons-lang3
    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
