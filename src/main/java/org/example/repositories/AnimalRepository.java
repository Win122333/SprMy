package org.example.repositories;

import org.example.models.Animal;

import java.util.List;
import java.util.ArrayList;

public class AnimalRepository implements IRepository<Animal> {
    private List<Animal> db;
    private int ID;

    public void save(Animal entity) {
        entity.setID(ID++);
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
        save(new Animal("Попугай", 322535, 50, 5));
        save(new Animal( "Тигр", 214124, 40, 5));
        save(new Animal("Черепаха", 1111111111, 200, 3));
        save(new Animal("Мухоловка", 1224142141, 2, 1));
        save(new Animal("Лобстер", 35235, 10, 4));
    }
}
