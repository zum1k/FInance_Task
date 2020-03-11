package view.menu;

import entity.Client;
import entity.ExpenseType;
import service.ClientService;
import service.UserService;
import view.consoleinput.ConsoleInput;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Menu {
    private Client client = null;
    private ConsoleInput consoleInput = new ConsoleInput();
    private UserService userService = new UserService();
    private ClientService clientService = new ClientService();

    private static final String COMMAND_1_MSG = "Введите на клавиатуре нужную команду:" + "\n" +
            "1 - LogIn" + "\n" + "2 - Register" + "\n" + "3 - Exit";
    private static final String COMMAND_2_MSG = "Введите на клавиатуре нужную команду:" + "\n" +
            "1 - Сделать запись" + "\n" +
            "2 - Получить все расходы" + "\n" +
            "3 - Получить расходы с даты" + "\n" +
            "4 - Получить расходы за период" + "\n" +
            "5 - Получить расходы на дату" + "\n" +
            "6 - Получить все расходы по типу" + "\n" +
            "7 - Получить расходы по типу с даты" + "\n" +
            "8 - Получить расходы по типу за период" + "\n" +
            "9 - Получить расходы по типу на дату" + "\n" +
            "10 - LogOut" + "\n" +
            "11 - Exit";
    private static final String LOGIN_MSG = "Введите логин:";
    private static final String PASSWORD_MSG = "Введите пароль";
    private static final String EXPENSE_TYPE_MSG = "Выберете тип расхода: " + Arrays.toString(ExpenseType.values()) + ": ";
    private static final String COST_MSG = "Укажите стоимость:";
    private static final String YEAR_MSG = "Введите год";
    private static final String MONTH_MSG = "Введите месяц";
    private static final String DAY_MSG = "Введите день";
    private static final String START_PERIOD_MSG = "Введите начала периода:";
    private static final String END_PERIOD_MSG = "Введите конец периода:";
    private static final String TYPE_EXCEPTION_MSG = "Данного типа расхода нет: выберете из существующих: " + Arrays.toString(ExpenseType.values()) + ": ";
    private static final String YEAR_EXPECTION_MSG = "Ошибка! Год должен быть не отрциательным";

    public void login() {
        String login = readLogin();
        String password = readPassword();
        client = userService.logIn(login, password);
        if (client != null) {
            runClientMenu();
        }
    }

    private void register() {
        String login = readLogin();
        String password = readPassword();
        client = userService.register(login, password);
        if (client != null) {
            runClientMenu();
        }
    }

    private void exit() {
        userService.exit();
    }

    private String readLogin() {
        System.out.println(LOGIN_MSG);
        return consoleInput.readString();
    }

    private String readPassword() {
        System.out.println(PASSWORD_MSG);
        return consoleInput.readString();
    }

    private ExpenseType readType() {
        int flag = 0;
        String exType = null;
        System.out.println(EXPENSE_TYPE_MSG);
        do {
            try {
                exType = consoleInput.readString();
                for (ExpenseType e : ExpenseType.values()) {
                    if (exType.equals(e.name())) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    throw new Exception(TYPE_EXCEPTION_MSG);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (flag != 1);
        return ExpenseType.valueOf(exType);
    }

    private Calendar getCalendar() {
        return Calendar.getInstance();
    }

    private int readYear() {
        System.out.println(YEAR_MSG);
        int year = consoleInput.readInt();
        while (year < 1) {
            System.out.println(YEAR_EXPECTION_MSG);
            year = consoleInput.readInt();
        }
        return year;
    }

    private int readMonth() {
        System.out.println(MONTH_MSG);
        int flag = 0;
        int month = 1;
        do {
            month = consoleInput.readInt();
            if (month < 1 || month > 12) {
                System.out.println("Ошибка! Месяц должен быть в пределах от 1 до 12!");
            } else {
                flag = 1;
            }
        }
        while (flag != 1);
        return month - 1;
    }

    private int readDay() {
        System.out.println(DAY_MSG);
        int flag = 0;
        int day = 1;
        do {
            day = consoleInput.readInt();
            if (day < 1 || day > 31) {
                System.out.println("Ошибка! День должен быть в пределах от 1 до 31!");
            } else {
                flag = 1;
            }
        }
        while (flag != 1);
        return day;
    }

    private BigDecimal readCost() {
        System.out.println(COST_MSG);
        double dS = consoleInput.readDouble();
        return new BigDecimal(dS);
    }

    private GregorianCalendar readDate() {
        int year = readYear();
        int month = readMonth();
        int day = readDay();
        return new GregorianCalendar(year, month, day);
    }

    private void showResult(List<String> strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }

    private void setExpense() {
        Calendar date = getCalendar();
        ExpenseType expenseType = readType();
        BigDecimal cost = readCost();
        clientService.setExpense(client.getId(), date, expenseType, cost);
    }

    private void getAll() {
        List<String> lines = clientService.getAll(client.getId());
        showResult(lines);
    }

    private void getAllFrom() {
        Calendar date = readDate();
        List<String> lines = clientService.getAllFrom(client.getId(), date);
        showResult(lines);
    }

    private void getAllFromTo() {
        System.out.println(START_PERIOD_MSG);
        Calendar date1 = readDate();

        System.out.println(END_PERIOD_MSG);
        Calendar date2 = readDate();
        List<String> lines = clientService.getAllFromTo(client.getId(), date1, date2);
        showResult(lines);
    }

    private void getAllByDate() {
        Calendar date = readDate();
        List<String> lines = clientService.getAllByDate(client.getId(), date);
        showResult(lines);
    }

    private void getAllExpenses() {
        ExpenseType expenseType = readType();
        List<String> lines = clientService.getAllExpenseType(client.getId(), expenseType);
        showResult(lines);
    }

    private void getAllExpensesFrom() {
        ExpenseType expenseType = readType();
        Calendar date = readDate();
        List<String> lines = clientService.getAllExpenseTypeFrom(client.getId(), expenseType, date);
        showResult(lines);
    }

    private void getAllExpensesFromTo() {
        ExpenseType expenseType = readType();

        System.out.println(START_PERIOD_MSG);
        Calendar date1 = readDate();

        System.out.println(END_PERIOD_MSG);
        Calendar date2 = readDate();

        List<String> lines = clientService.getAllExpenseTypeFromTo(client.getId(), expenseType, date1, date2);
        showResult(lines);
    }

    private void getAllExpensesByDate() {
        ExpenseType expenseType = readType();
        Calendar date1 = readDate();
        List<String> lines = clientService.getAllExpenseTypeByDate(client.getId(), expenseType, date1);
        showResult(lines);
    }

    public void runUserMenu() {
        this.client = null;
        ConsoleInput consoleInput = new ConsoleInput();
        this.userService = new UserService();
        System.out.println(COMMAND_1_MSG);
        int var = 0;
        do {
            var = consoleInput.readInt();
            switch (var) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    exit();
            }
        } while (var != 3);
        System.out.println("До свидания!");

    }

    private void runClientMenu() {
        System.out.println(COMMAND_2_MSG);
        this.clientService = new ClientService();
        int var = 0;
        do {
            var = consoleInput.readInt();
            switch (var) {
                case 1:
                    setExpense();
                    break;
                case 2:
                    getAll();
                    break;
                case 3:
                    getAllFrom();
                    break;
                case 4:
                    getAllFromTo();
                    break;
                case 5:
                    getAllByDate();
                    break;
                case 6:
                    getAllExpenses();
                    break;
                case 7:
                    getAllExpensesFrom();
                    break;
                case 8:
                    getAllExpensesFromTo();
                    break;
                case 9:
                    getAllExpensesByDate();
                    break;
                case 10:
                    client = userService.logOut();
                    System.out.println(COMMAND_1_MSG);
                    break;
                case 11:
                    exit();
            }

        } while (var != 10);
    }

}
