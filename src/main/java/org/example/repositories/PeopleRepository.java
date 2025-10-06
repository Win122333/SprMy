package org.example.repositories;

import org.example.models.Animal;
import org.example.models.Music;
import org.example.models.People;

import java.util.ArrayList;
import java.util.List;

public class PeopleRepository implements IRepository<People> {
    private List<People> db;
    private int ID = 0;

    @Override
    public void save(People entity) {
        if (entity.getID() == 0) {
            entity.setID(ID++);
        }
        db.add(entity);
    }

    @Override
    public People findById(int id) {
        for (People people : db) {
            if (people.getID() == id) {
                return people;
            }
        }
        throw new RuntimeException("нет такого id == " + id);
    }

    @Override
    public List<People> findAll() {
        return new ArrayList<>(db);
    }

    @Override
    public boolean delete(int id) {
        for (People people : db) {
            if (people.getID() == id) {
                db.remove(people);
                return true;
            }
        }
        throw new RuntimeException("нет такого id == " + id);
    }

    @Override
    public void update(People entity, int id) {
        for (People people : db) {
            if (people.getID() == id) {
                people.setAge(entity.getAge());
                people.setCitizenship(entity.getCitizenship());
                people.setFirstName(entity.getFirstName());
                people.setLastName(entity.getLastName());
            }
        }
    }

    public PeopleRepository() {
        db = new ArrayList<>();
        save(new People(0, "RTRTR", "dfdfdf", 111, "RUS"));
        save(new People(0, "oooo", "yyyy", 112, "RUS"));
        save(new People(0, "iiiii", "uuuu", 113, "RUS"));
        save(new People(0, "uuuuu", "tttt", 114, "RUS"));
        save(new People(0, "yyyyy", "oooo", 115, "RUS"));
    }
}
