package dao.checker.expense;

import dao.checker.Checker;
import dao.mapper.ExpenseMapper;
import dao.mapper.impl.ExpenseMapperImpl;
import entity.Expense;
import entity.ExpenseType;

import java.util.Calendar;

public class ExpenseCheckerByTypeFromTo implements Checker {

    private int id;
    private Calendar date1;
    private Calendar date2;
    private ExpenseType expenseType;

    public ExpenseCheckerByTypeFromTo(int id, Calendar date1, Calendar date2, ExpenseType expenseType) {
        this.id = id;
        this.date1 = date1;
        this.date2 = date2;
        this.expenseType = expenseType;
    }

    @Override
    public boolean check(String string) {
        ExpenseMapper expenseMapper = new ExpenseMapperImpl();
        Expense expense = expenseMapper.toExpense(string);
        return id == expense.getId() && (date1.compareTo(expense.getCalendar()) <= 0)
                && (date2.compareTo(expense.getCalendar()) >= 0) &&
                (expenseType.compareTo(expense.getExpenseType() ) == 0);
    }
}

