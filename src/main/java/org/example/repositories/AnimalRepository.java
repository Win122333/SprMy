package org.example.repositories;

import org.example.models.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepository implements IRepository<Animal> {
    private List<Animal> db;
    private int ID;

    public void save(Animal entity) {
        if (entity.getID() == 0) {
            entity.setID(ID++);
        }
        db.add(entity);
    }

    @Override
    public Animal findById(int id) {
        for (Animal animal : db) {
            if (animal.getID() == id) {
                return animal;
            }
        }
        throw new RuntimeException("нет такого id == " + id);
    }

    @Override
    public List<Animal> findAll() {
        return new ArrayList<>(db);
    }

    @Override
    public boolean delete(int id) {
        for (Animal animal : db) {
            if (animal.getID() == id) {
                db.remove(animal);
                return true;
            }
        }
        throw new RuntimeException("нет такого id == " + id);
    }

    @Override
    public void update(Animal entity, int id) {
        for (Animal animal : db) {
            if (animal.getID() == id) {
                animal.setScienceName(entity.getScienceName());
                animal.setPopulation(entity.getPopulation());
                animal.setAvgLife(entity.getAvgLife());
            }
        }
    }

    public AnimalRepository() {
        this.db = new ArrayList<>();
        ID = 1;
        save(new Animal(0,"Попугай", 322535, 50));
        save(new Animal(0, "Тигр", 214124, 40));
        save(new Animal(0,"Черепаха", 1111111111, 200));
        save(new Animal(0,"Мухоловка", 1224142141, 2));
        save(new Animal(0,"Лобстер", 35235, 10));
    }
}
