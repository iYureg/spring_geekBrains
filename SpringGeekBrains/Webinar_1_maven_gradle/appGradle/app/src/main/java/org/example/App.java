/*
 * This source file was generated by the Gradle 'init' task
 *
 * gradle init --type java-application
 */
package org.example;

public class App {
    public String getGreeting() {
        return "Привет, Мир!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
