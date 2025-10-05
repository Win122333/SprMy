package org.example;
import java.util.Arrays;

import static org.example.console.Console.start;

public class Main {
    public static void main(String[] args) {
        DB.initDB();
        DB.getDB();
        start();
    }
}