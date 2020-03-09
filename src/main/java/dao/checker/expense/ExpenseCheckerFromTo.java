package dao.checker.expense;

import dao.checker.Checker;
import dao.mapper.ExpenseMapper;
import dao.mapper.impl.ExpenseMapperImpl;
import entity.Expense;

import java.util.Calendar;

public class ExpenseCheckerFromTo implements Checker {

    private int id;
    private Calendar date1;
    private Calendar date2;

    public ExpenseCheckerFromTo(int id, Calendar date1, Calendar date2) {
        this.id = id;
        this.date1 = date1;
        this.date2 = date2;
    }

    @Override
    public boolean check(String string) {
        ExpenseMapper expenseMapper = new ExpenseMapperImpl();
        Expense expense = expenseMapper.toExpense(string);
        return id == expense.getId() && (date1.compareTo(expense.getCalendar()) <= 0)
                && (date2.compareTo(expense.getCalendar()) >= 0);

    }
}


