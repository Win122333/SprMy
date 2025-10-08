package org.example.controllers;

import org.example.models.People;
import org.example.services.InputService;
import org.example.services.PeopleService;

public class PeopleController implements IController {
    PeopleService peopleService;
    InputService inputService;

    @Override
    public void create() {
        try {
            System.out.println("Начнём создание нашего человека!");

            String firstName = inputService.readString("Введите его научное имя");
            String lastName = inputService.readString("Введите его научное фамилию");
            int age = inputService.readInt("Введите возраст");
            String citizenship = inputService.readString("Введите гражданство");

            People people = new People(firstName, lastName, age, citizenship);
            peopleService.create(people);

            System.out.println("✅ Человек успешно создано!");
        }
        catch (Exception e) {
            System.out.println("❌ Ошибка при создании животного: " + e.getMessage());
            System.out.println("Попробуйте снова!");
        }
    }

    @Override
    public void getAll() {
        for (People people : peopleService.getAll()) {
            System.out.println(people);
        }
    }

    @Override
    public void getItemById() {
        System.out.println(peopleService.getItemById(inputService.readInt("ВВЕДИ ID")));
    }

    @Override
    public void delete() {
        try {
            peopleService.delete(inputService.readInt("Введите id элемента, который хотите удалить"));
            System.out.println("✅ УСПЕШНО УДАЛЕНО!");
        }
        catch (Exception e) {
            System.out.println("❌ Ошибка при удалении животного: " + e.getMessage());
            System.out.println("Попробуйте снова!");
        }
    }

    @Override
    public void update() {
        try {
            int ID = inputService.readInt("Введите id элемента, который хотите заменить");
            String firstName = inputService.readString("Введите его научное имя");
            String lastName = inputService.readString("Введите его научное фамилию");
            int age = inputService.readInt("Введите возраст");
            String citizenship = inputService.readString("Введите гражданство");


            People people = new People(firstName, lastName, age, citizenship);
            peopleService.update(people, ID);
        }
        catch (Exception e) {
            System.out.println("❌ Ошибка при обновлении: " + e.getMessage());
            System.out.println("Попробуйте снова!");
        }
    }

    public PeopleController(PeopleService peopleService, InputService inputService) {
        this.peopleService = peopleService;
        this.inputService = inputService;
    }
}
