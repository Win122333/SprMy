package org.example.services;


import org.example.repositories.AnimalRepositoryJDBC;
import org.example.repositories.MusicRepositoryJDBC;
import org.example.repositories.PeopleRepositoryJDBC;

public class ServiceFactory {
    private static AnimalService animalService;
    private static MusicService musicService;
    private static PeopleService peopleService;

    public static AnimalService getAnimalService() {
        if (animalService == null) {
            animalService = new AnimalService(new AnimalRepositoryJDBC());
        }
        return animalService;
    }
    public static MusicService getMusicService() {
        if (musicService == null) {
            musicService = new MusicService(new MusicRepositoryJDBC());
        }
        return musicService;
    }
    public static PeopleService getPeopleService() {
        if (peopleService == null) {
            peopleService = new PeopleService(new PeopleRepositoryJDBC());
        }
        return peopleService;
    }
}
