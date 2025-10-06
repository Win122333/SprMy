package org.example.services;

import java.util.Scanner;

public class InputService {
    private Scanner scanner;

    public InputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String prompt) {
        System.out.println(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Ошибка: введите целое число!");
            }
        }
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        while (true) {
            try {
                return Long.parseLong(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("❌ Ошибка: введите число!");
            }
        }
    }

    public String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    public char parseArg() {
        while (true) {
            try {
                String str = scanner.nextLine();
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '-' && (i + 1) < str.length()) {
                        return str.charAt((i + 1));
                    }
                }
                return str.charAt(0);
            } catch (NumberFormatException e) {
                System.out.println("❌ Ошибка: введите целое число!");
            }
        }
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}