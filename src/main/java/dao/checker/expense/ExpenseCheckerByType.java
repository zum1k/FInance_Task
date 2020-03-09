package dao.checker.expense;

import dao.checker.Checker;
import dao.mapper.ExpenseMapper;
import dao.mapper.impl.ExpenseMapperImpl;
import entity.Expense;
import entity.ExpenseType;

public class ExpenseCheckerByType implements Checker {

    private int id;
    private ExpenseType expenseType;

    public ExpenseCheckerByType(int id, ExpenseType expenseType) {
        this.id = id;
        this.expenseType = expenseType;
    }

    @Override
    public boolean check(String string) {
        ExpenseMapper mapper = new ExpenseMapperImpl();
        Expense expense = mapper.toExpense(string);
        return expense.getId() == id && expense.getExpenseType() == expenseType;
    }
}
