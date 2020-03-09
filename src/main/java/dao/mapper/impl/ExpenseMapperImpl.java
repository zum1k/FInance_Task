package dao.mapper.impl;

import dao.mapper.ExpenseMapper;
import entity.Expense;
import entity.ExpenseType;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExpenseMapperImpl implements ExpenseMapper {
    public static final String DATE_FORMAT = "yyyy.MM.dd";
    public static final String SPACE_SPLITERATOR = " ";
    public static final String DOT_SPLITERATOR = "\\.";

    public static final int ID_INDEX = 0;
    public static final int DATE_INDEX = 1;
    public static final int EXPENSE_TYPE_INDEX = 2;

    public static final int YEAR_INDEX = 0;
    public static final int MONTH_INDEX = 1;
    public static final int DAY_INDEX = 2;
    public static final int BIG_DECIMAL_INDEX = 3;

    @Override
    public String toString(Expense expense) {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat(DATE_FORMAT);
        String date = formatForDateNow.format(expense.getCalendar().getTime());
        return expense.getId() + SPACE_SPLITERATOR + date + SPACE_SPLITERATOR + expense.getExpenseType() + SPACE_SPLITERATOR + expense.getCost();
    }

    @Override
    public Expense toExpense(String string) {
        String[] strings = string.split(SPACE_SPLITERATOR);
        Expense expense = new Expense();

        expense.setId(Integer.parseInt(strings[ID_INDEX]));

        String date = strings[DATE_INDEX];
        Calendar calendar = getDate(date);
        expense.setCalendar(calendar);

        expense.setExpenseType(ExpenseType.valueOf(strings[EXPENSE_TYPE_INDEX]));

        BigDecimal cost = new BigDecimal(strings[BIG_DECIMAL_INDEX]);
        expense.setCost(cost);

        return expense;
    }

    public GregorianCalendar getDate(String string) {
        String[] date = string.split(DOT_SPLITERATOR);
        int year = Integer.parseInt(date[YEAR_INDEX]);
        int month = Integer.parseInt(date[MONTH_INDEX]) - 1;
        int day = Integer.parseInt(date[DAY_INDEX]);
        return new GregorianCalendar(year, month, day);
    }
}
