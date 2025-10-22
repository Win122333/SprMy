package org.example.services;

import org.example.models.People;
import org.example.repositories.IRepository;
import org.example.repositories.PeopleRepository;
import org.example.repositories.PeopleRepositoryJDBC;

import java.util.List;

public class PeopleService implements IService<People> {
    IRepository<People> peopleRepository;

    @Override
    public List<People> getAll() {
        return peopleRepository.findAll();
    }

    @Override
    public People getItemById(int id) {
        return peopleRepository.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return peopleRepository.delete(id);
    }

    @Override
    public void update(People entity, int id) {
        peopleRepository.update(entity, id);
    }

    @Override
    public void create(People entity) {
        peopleRepository.save(entity);
    }

    public PeopleService(IRepository<People> peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
}
