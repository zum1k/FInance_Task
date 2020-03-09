package dao.checker.expense;

import dao.checker.Checker;
import dao.mapper.ExpenseMapper;
import dao.mapper.impl.ExpenseMapperImpl;
import entity.Expense;

public class ExpenseCheckerByID implements Checker {
    private int id;

    public ExpenseCheckerByID(int id) {
        this.id = id;
    }

    @Override
    public boolean check(String string) {
        ExpenseMapper expenseMapper = new ExpenseMapperImpl();
        Expense expense = expenseMapper.toExpense(string);
        return id == expense.getId();
    }
}

