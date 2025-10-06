package org.example.controllers;

import org.example.models.Music;
import org.example.services.InputService;
import org.example.services.MusicService;

import java.util.Scanner;

public class MusicController implements IController {
    private final MusicService musicService;
    private final InputService inputService;

    @Override
    public void create() {
        System.out.println("ДАВАЙТЕ СОЗДАДИМ МУЗЫКУ?!?!?!?");
        String title = inputService.readString("ВВЕДИ НАЗВАНИЕ");
        String autor = inputService.readString("ВВЕДИ АВТОРА");
        int duratrion = inputService.readInt("ВВЕДИ ДЛИТЕЛЬНОСТЬ");
        Music music = new Music(0, title, autor, duratrion);

        musicService.create(music);
    }

    @Override
    public void getAll() {
        for (Music music : musicService.getAll()) {
            System.out.println(music);
        }
    }

    @Override
    public void getItemById() {
        musicService.getItemById(inputService.readInt("ВВЕДИ ID"));
    }

    @Override
    public void delete() {
        try {
            musicService.delete(inputService.readInt("Введите id элемента, который хотите удалить"));
            System.out.println("✅ УСПЕШНО УДАЛЕНО!");
        }
        catch (Exception e) {
            System.out.println("❌ Ошибка при удалении животного: " + e.getMessage());
            System.out.println("Попробуйте снова!");
        }
    }

    @Override
    public void update() {
        try {
            int ID = inputService.readInt("Введите id элемента, который хотите заменить");
            String title = inputService.readString("Введите его название");
            String autor = inputService.readString("Введите автора");
            int duration = inputService.readInt("Введите длительность");

            Music music = new Music(ID, title, autor, duration);
            musicService.update(music, ID);
        }
        catch (Exception e) {
            System.out.println("❌ Ошибка при обновлении: " + e.getMessage());
            System.out.println("Попробуйте снова!");
        }
    }

    public MusicController(MusicService musicService, InputService inputService) {
        this.musicService = musicService;
        this.inputService = inputService;
    }
}
