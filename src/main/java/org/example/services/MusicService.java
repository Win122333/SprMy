package org.example.services;

import org.example.models.Music;
import org.example.repositories.MusicRepository;

import java.util.List;

public class MusicService implements IService<Music> {
    private final MusicRepository musicRepository;

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

    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }
}
