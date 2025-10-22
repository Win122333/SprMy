package org.example.services;

import org.example.models.Music;
import org.example.repositories.IRepository;
import org.example.repositories.MusicRepositoryJDBC;

import java.util.List;

public class MusicService implements IService<Music> {
    private final IRepository<Music> musicRepository;

    @Override
    public List<Music> getAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music getItemById(int id) {
        return musicRepository.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return musicRepository.delete(id);
    }

    @Override
    public void update(Music entity, int id) {
        musicRepository.update(entity, id);
    }

    @Override
    public void create(Music entity) {
        musicRepository.save(entity);
    }

    public MusicService(IRepository<Music> musicRepository) {
        this.musicRepository = musicRepository;
    }
}
