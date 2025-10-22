package org.example.services;

import org.example.real_estate.models.Deal;

import java.util.List;

public class DealService implements IService<Deal> {

    @Override
    public List<Deal> getAll() {
        return null;
    }

    @Override
    public Deal getItemById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void update(Deal entity, int id) {

    }

    @Override
    public void create(Deal entity) {

    }
}
