package dao.mapper;

import entity.Expense;

public interface ExpenseMapper {
    String toString(Expense expense);
    Expense toExpense(String string);
}
