package org.example.repositories;

import org.example.models.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicRepository implements IRepository<Music> {
    private List<Music> db;
    private int ID = 0;

    @Override
    public void save(Music entity) {
        if (entity.getID() == 0) {
            entity.setID(ID++);
        }
        db.add(entity);
    }

    @Override
    public Music findById(int id) {
        for (Music music : db) {
            if (music.getID() == id) {
                return music;
            }
        }
        throw new RuntimeException("нет такого id == " + id);
    }

    @Override
    public List<Music> findAll() {
        return new ArrayList<>(db);
    }

    @Override
    public boolean delete(int id) {
        for (Music music : db) {
            if (music.getID() == id) {
                db.remove(music);
                return true;
            }
        }
        throw new RuntimeException("нет такого id == " + id);
    }

    @Override
    public void update(Music entity, int id) {
        for (Music music : db) {
            if (music.getID() == id) {
                music.setTitle(entity.getTitle());
                music.setAutor(entity.getAutor());
                music.setDuration(entity.getDuration());
            }
        }
    }

    public MusicRepository() {
        db = new ArrayList<>();
        save(new Music(0, "Слава кпсс", "Слава кпсс", 180));
        save(new Music(0, "Шёлк", "Ваня Дмитриенко", 200));
        save(new Music(0, "Бассейн", "Noize MC", 210));
        save(new Music(0, "На луне", "Серега Пират", 170));
        save(new Music(0, "3 6 9", "FORTUNA 812", 150));
    }
}
