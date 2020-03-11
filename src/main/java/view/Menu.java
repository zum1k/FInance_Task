package view;

public class Menu {
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
    public static final String LOGIN_MSG = "Введите логин:";
    public static final String PASSWORD_MSG = "Введите пароль";
    public static final String EXPENSE_TYPE_MSG = "Ввыберете тип расхода:";
    public void printPasswordMSG(){
        System.out.println(PASSWORD_MSG);
    }
    public void printLoginMSG(){
        System.out.println(LOGIN_MSG);
    }
    public void printTypeMSG(){
        System.out.println(EXPENSE_TYPE_MSG);
    }
    public void printUserCommand(){
        System.out.println(COMMAND_1_MSG);
    }
    public void printClientCommand(){
        System.out.println(COMMAND_2_MSG
        );
    }
}
