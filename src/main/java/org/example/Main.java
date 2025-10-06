package org.example;
import org.example.console.Console;
import org.example.controllers.AnimalController;
import org.example.controllers.MusicController;
import org.example.controllers.PeopleController;
import org.example.repositories.AnimalRepository;
import org.example.repositories.MusicRepository;
import org.example.repositories.PeopleRepository;
import org.example.services.AnimalService;
import org.example.services.InputService;
import org.example.services.MusicService;
import org.example.services.PeopleService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        InputService inputService = new InputService(new Scanner(System.in));
        AnimalController animalController = new AnimalController(new AnimalService(new AnimalRepository()), inputService);
        MusicController musicController = new MusicController(new MusicService(new MusicRepository()), inputService);
        PeopleController peopleController = new PeopleController(new PeopleService(new PeopleRepository()), inputService);

        Console console = new Console(inputService, animalController, musicController, peopleController);
        console.start();
    }
}