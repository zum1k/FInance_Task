package dao.checker.expense;

import dao.checker.Checker;
import dao.mapper.ExpenseMapper;
import dao.mapper.impl.ExpenseMapperImpl;
import entity.Expense;
import entity.ExpenseType;

import java.util.Calendar;

public class ExpenseCheckerByTypeFrom implements Checker {

    private int id;
    private Calendar date;
    private ExpenseType expenseType;

    public ExpenseCheckerByTypeFrom(int id, Calendar date, ExpenseType expenseType) {
        this.id = id;
        this.date = date;
        this.expenseType = expenseType;
    }

    @Override
    public boolean check(String string) {
        ExpenseMapper expenseMapper = new ExpenseMapperImpl();
        Expense expense = expenseMapper.toExpense(string);
        return id == expense.getId() && (expenseType.compareTo(expense.getExpenseType())==0) &&
                (date.compareTo(expense.getCalendar()) <= 0);
    }
}
