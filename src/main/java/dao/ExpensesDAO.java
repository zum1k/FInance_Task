package dao;

import entity.Expense;
import entity.ExpenseType;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public interface ExpensesDAO {
    List<Expense> getAll();

    List<Expense> getAllFrom(Calendar date1);

    List<Expense> getAllFromTo(Calendar date1, Calendar date2);

    List<Expense> getAllByDate(Calendar date);

    List<Expense> getAllByType(ExpenseType expenseType);

    List<Expense> getAllByExpenseTypeFromDate(ExpenseType expenseType,Calendar date);

    List<Expense> getAllExpenseTypeFromTo(ExpenseType expenseType, Calendar date1, Calendar date2);

    List<Expense> getExpenseTypeByDate(ExpenseType expenseType, Calendar date);

    void setExpense(int id, Calendar date, ExpenseType expenseType, BigDecimal cost) throws IOException;

}
