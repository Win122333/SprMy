package org.example.controllers;

import org.example.models.Animal;
import org.example.services.AnimalService;
import org.example.services.InputService;


public class AnimalController implements IController {
    private final InputService inputService;
    private final AnimalService animalService;

    @Override
    public void create() {
        try {
            System.out.println("Начнём создание нашего живтного!");

            String scienceName = inputService.readString("Введите его научное название");
            long population = inputService.readLong("Введите число особей");
            int avgLife = inputService.readInt("Введите среднее время жизни");

            Animal animal = new Animal(scienceName, population, avgLife);
            animalService.create(animal);

            System.out.println("✅ Животное успешно создано!");
            System.out.println("Присвоен ID: " + animal.getID());
            System.out.println("Название: " + animal.getScienceName());
            System.out.println("Популяция: " + animal.getPopulation());
            System.out.println("Продолжительность жизни: " + animal.getAvgLife() + " лет");
        }
        catch (Exception e) {
            System.out.println("❌ Ошибка при создании животного: " + e.getMessage());
            System.out.println("Попробуйте снова!");
        }
    }

    @Override
    public void getAll() {
        for (Animal animal : animalService.getAll()) {
            System.out.println(animal);
        }
    }

    @Override
    public void getItemById() {
        System.out.println(animalService.getItemById(inputService.readInt("Выберите id элемиента, который хотите вывести")));
    }

    @Override
    public void delete() {
        try {
            animalService.delete(inputService.readInt("Введите id элемента, который хотите удалить"));
            System.out.println("✅ Животное успешно удалено!");
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
            String scienceName = inputService.readString("Введите его научное название");
            long population = inputService.readLong("Введите число особей");
            int avgLife = inputService.readInt("Введите среднее время жизни");

            Animal animal = new Animal(scienceName, population, avgLife);
            animalService.update(animal, ID);
        }
        catch (Exception e) {
            System.out.println("❌ Ошибка при обновлении животного: " + e.getMessage());
            System.out.println("Попробуйте снова!");
        }
    }

    public AnimalController(AnimalService animalService, InputService inputService) {
        this.animalService = animalService;
        this.inputService = inputService;
    }
}
