package view.consoleinput;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt() {
        int flag = 0;
        int value = 0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextInt()) {
                    flag = 1;
                    value = scanner.nextInt();
                    break;
                }
                if (flag == 0) {
                    throw new Exception("Введите число!");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (flag != 1);
        return value;
    }

    public double readDouble() {
        int flag = 0;
        double value = 0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNextDouble()) {
                    flag = 1;
                    value = scanner.nextDouble();
                    break;
                }
                if (flag == 0) {
                    throw new Exception("Введите число!");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (flag != 1);
        return value;
    }

    public String readString() {
        return scanner.next();
    }
}