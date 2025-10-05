package org.example.console;

import org.example.DB;
import org.example.models.Music;

import java.util.Arrays;
import java.util.Scanner;

public class Console {
    private static Scanner sc = new Scanner(System.in);
    public static void start() {
        while (true) {
            System.out.println("\nВыберите один из вариантов:\n" +
                    "\"-c\" (create)                            -b(назад)\n" +
                    "\"-r\" (read)\n" +
                    "\"-u\" (update)\n" +
                    "\"-d\" (delete)\n"
            );
            char c = parse(sc.nextLine());
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
    private static char parse(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' && (i + 1) < str.length()) {
                return str.charAt((i + 1));
            }
        }
        return str.charAt(0);
    }
    private static void read() {
        System.out.println("Все значения в БД:");
        System.out.println(DB.getDB());
    }
    private static void delete() {
        System.out.println("Элемент под каким номером удалить?");
    }
    private static void create() {
        System.out.println("Выберите обьект, который хотит создать:\n" +
                "1) Music");
        char c = parse(sc.nextLine());
        if (c == '1') {
            System.out.println("Введите название песни, исполнителя и длительность");
            String[] arg = sc.nextLine().split(" ");
            System.out.println(Arrays.toString(arg));
            if (arg.length == 3) {
                DB.save(new Music(arg[0], arg[1], Integer.parseInt(arg[2])));
                System.out.println("Запись добавлена");
            }
        }
    }
    private static void update() {
    }
}
