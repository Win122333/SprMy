package org.example.services;

import org.example.models.Animal;
import org.example.repositories.AnimalRepository;

import java.util.List;

public class AnimalService implements IService<Animal> {
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getItemById(int id) {
        return animalRepository.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return animalRepository.delete(id);
    }


    @Override
    public void update(Animal entity, int id) {
        animalRepository.update(entity, id);
    }

    @Override
    public void create(Animal entity) {
        animalRepository.save(entity);
    }

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

}
