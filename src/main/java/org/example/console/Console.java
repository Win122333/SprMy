package org.example.console;

import org.example.controllers.AnimalController;
import org.example.controllers.MusicController;
import org.example.controllers.PeopleController;
import org.example.services.InputService;


public class Console {
    private final InputService inputService;
    private final AnimalController animalController;
    private final MusicController musicController;
    private final PeopleController peopleController;


    public void start() {
        while (true) {
            System.out.println("\nВыберите один из вариантов:\n" +
                    "\"-c\" (create)                            -b(назад)\n" +
                    "\"-r\" (read)\n" +
                    "\"-u\" (update)\n" +
                    "\"-d\" (delete)\n"
            );
            char c = inputService.parseArg();
            if (c == '0') {
                continue;
            }
            else if (c == 'c') {
                create();
            }
            else if (c == 'r') {
                read();
            }
            else if (c == 'u') {
                update();
            }
            else if (c == 'd') {
                delete();
            }
        }
    }

    private void read() {
        chooseModel();
        int idEntity = inputService.readInt("");
        int idChoose = inputService.readInt("ВЫБЕРИТЕ ВАРИАНТ:\n" +
                "1 (ВЫВЕСТИ ВСЁ)\n" +
                "2 (ВЫВЕСТИ ПО ID)");

        if (idEntity == 1) {
            if (idChoose == 1) {
                animalController.getAll();
            }
            else if (idChoose == 2) {
                animalController.getItemById();
            }
        }
        else if (idEntity == 2) {
            if (idChoose == 1) {
                musicController.getAll();
            }
            else if (idChoose == 2) {
                musicController.getItemById();
            }
        }
        else if (idEntity == 3) {
            if (idChoose == 1) {
                peopleController.getAll();
            }
            else if (idChoose == 2) {
                peopleController.getItemById();
            }
        }
        else {
            System.out.println("❌ НЕТ ТАКОГО ВАРИАНТА");
        }
    }
    private void delete() {
        chooseModel();
        int id = inputService.readInt("");
        if (id == 1) {
            animalController.delete();
        }
        else if (id == 2) {
            musicController.delete();
        }
        else if (id == 3) {
            peopleController.delete();
        }
        else {
            System.out.println("❌ НЕТ ТАКОГО ВАРИАНТА");
        }
    }
    private void create() {
        chooseModel();
        int id = inputService.readInt("");
        if (id == 1) {
            animalController.create();
        }
        else if (id == 2) {
            musicController.create();
        }
        else if (id == 3) {
            peopleController.create();
        }
        else {
            System.out.println("❌ НЕТ ТАКОГО ВАРИАНТА");
        }
    }
    private void update() {
        chooseModel();
        int id = inputService.readInt("");
        if (id == 1) {
            animalController.update();
        }
        else if (id == 2) {
            musicController.update();
        }
        else if (id == 3) {
            peopleController.update();
        }
        else {
            System.out.println("❌ НЕТ ТАКОГО ВАРИАНТА");
        }
    }
    private void chooseModel() {
        System.out.println("\nВыберите один из вариантов:\n" +
                "1 (Animal)\n" +
                "2 (Music)\n" +
                "3 (People)\n"
        );
    }

    public Console(InputService inputService, AnimalController animalController, MusicController musicController, PeopleController peopleController) {
        this.inputService = inputService;
        this.animalController = animalController;
        this.musicController = musicController;
        this.peopleController = peopleController;
    }
}
