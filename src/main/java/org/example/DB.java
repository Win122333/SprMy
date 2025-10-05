package org.example;

import org.example.models.IModel;
import org.example.models.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DB {
    private static List<IModel> db = new ArrayList<>();
    public static void initDB() {
        Random rnd = new Random();
        for (int i = 0; i < 2; i++) {
            db.add(new Music("Песня_" + rnd.nextInt(200), "Автор_" + rnd.nextInt(200), rnd.nextInt(1, 1000)));
        }
    }
    public static void save(IModel model) {
        db.add(model);
    }
    public static List<IModel> getDB() {
        return new ArrayList<>(db);
    }
}
