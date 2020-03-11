package dao.checker.expense;

import dao.checker.Checker;
import dao.mapper.ExpenseMapper;
import dao.mapper.impl.ExpenseMapperImpl;
import entity.Expense;

import java.util.Calendar;

public class ExpenseCheckerFrom implements Checker {
    private int id;
    private Calendar date;

    public ExpenseCheckerFrom(int id, Calendar date) {
        this.id = id;
        this.date = date;
    }

    @Override
    public boolean check(String string) {
        ExpenseMapper expenseMapper = new ExpenseMapperImpl();
        Expense expense = expenseMapper.toExpense(string);
        return id == expense.getId() && (date.compareTo(expense.getCalendar()) <= 0);
    }
}
