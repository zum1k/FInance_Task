package view;

import ConsoleInput.ConsoleInput;
import entity.Client;
import entity.ExpenseType;
import service.ClientService;
import service.UserService;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class Runner {
    public static void main(String[] args) {
        Client client = null;
        ConsoleInput consoleInput = new ConsoleInput();

        if (client == null) {
            System.out.println("Введите на клавиатуре нужную команду:" + "\n" +
                    "1 - LogIn" + "\n" + "2 - Register" + "\n" + "3 - Exit");
            int var = consoleInput.readInt();
            UserService userService = new UserService();

            switch (var) {
                case 1:
                    System.out.println("Введите логин:");
                    String login = consoleInput.readString();
                    System.out.println("Введите пароль:");
                    String password = consoleInput.readString();
                    client = userService.logIn(login, password);
                    break;
                case 2:
                    System.out.println("Введите логин:");
                    login = consoleInput.readString();
                    System.out.println("Введите пароль");
                    password = consoleInput.readString();
                    client = userService.register(login, password);
                    break;
                case 3:
                    userService.exit();
                    break;
            }
            if (client != null) {
                ClientService clientService = new ClientService();
                System.out.println("Введите на клавиатуре нужную команду:" + "\n" +
                        "1 - Сделать запись" + "\n" +
                        "2 - Получить все расходы" + "\n" +
                        "3 - Получить расходы с даты" + "\n" +
                        "10 - LogOut" + "\n" +
                        "11 - Exit");
                var = consoleInput.readInt();
                switch (var) {
                    case 1:
                        Calendar date = Calendar.getInstance();
                        System.out.println("Ввыберете тип расхода:");
                        String exType = consoleInput.readString();
                        ExpenseType expenseType = ExpenseType.valueOf(exType);
                        System.out.println("Укажите стоимость:");
                        double dS = consoleInput.readDouble();
                        BigDecimal cost = new BigDecimal(dS);
                        clientService.setExpense(client.getId(), date, expenseType, cost);
                        break;

                    case 2:
                        List<String> lines = clientService.getAll(client.getId());
                        for (String s : lines) {
                            System.out.println(s);
                        }
                        break;
                    case 3:
                        System.out.println("Введите год");
                        int year = consoleInput.readInt();
                        System.out.println("Введите месяц");
                        int month = consoleInput.readInt() - 1;
                        System.out.println("Введите день");
                        int day = consoleInput.readInt();
                        date = new GregorianCalendar(year, month, day);
                        lines = clientService.getAllFrom(client.getId(), date);
                        for (String s : lines) {
                            System.out.println(s);
                        }
                        break;
            }
        }
    }
}
}

