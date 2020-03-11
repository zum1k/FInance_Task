package dao.impl;

import dao.ExpensesDAO;
import dao.checker.expense.*;
import dao.checker.Checker;
import dao.exception.DAOException;
import dao.filemanager.FileManager;
import dao.mapper.ExpenseMapper;
import dao.mapper.impl.ExpenseMapperImpl;
import dao.filemanager.FileManagerImpl;
import entity.Expense;
import entity.ExpenseType;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExpenseDAOImpl implements ExpensesDAO {
    private static final String FILEPATH = "src/main/resources/Expenses.txt";
   private int id;

    public ExpenseDAOImpl(int id) {
        this.id = id;
    }

    @Override
    public List<Expense> getAll() {
        Checker checker = new ExpenseCheckerByID(id);
        return loadExpenses(checker);
    }

    @Override
    public List<Expense> getAllFrom(Calendar date1) {
        Checker checker = new ExpenseCheckerFrom(id, date1);
        return loadExpenses(checker);
    }

    @Override
    public List<Expense> getAllFromTo(Calendar date1, Calendar date2) {
        Checker checker = new ExpenseCheckerFromTo(id, date1, date2);
        return loadExpenses(checker);
    }

    @Override
    public List<Expense> getAllByDate(Calendar date) {
        Checker checker = new ExpenseCheckerByDate(id, date);
        return loadExpenses(checker);
    }

    @Override
    public List<Expense> getAllByType(ExpenseType expenseType) {
        Checker checker = new ExpenseCheckerByType(id, expenseType);
        return loadExpenses(checker);
    }

    @Override
    public List<Expense> getAllByExpenseTypeFromDate(ExpenseType expenseType, Calendar date) {
        Checker checker = new ExpenseCheckerByTypeFrom(id, date, expenseType);
        return loadExpenses(checker);
    }

    @Override
    public List<Expense> getAllExpenseTypeFromTo(ExpenseType expenseType, Calendar date1, Calendar date2) {
        Checker checker = new ExpenseCheckerByTypeFromTo(id, date1, date2, expenseType);
        return loadExpenses(checker);
    }

    @Override
    public List<Expense> getExpenseTypeByDate(ExpenseType expenseType, Calendar date) {
        Checker checker = new ExpenseCheckerByTypeDate(id, date, expenseType);
        return loadExpenses(checker);
    }

    @Override
    public void setExpense(int id, Calendar date, ExpenseType expenseType, BigDecimal cost)  {
        ExpenseMapper expenseMapper = new ExpenseMapperImpl();
        Expense expense = new Expense(id,date, expenseType, cost);
        String string = expenseMapper.toString(expense);
        FileManager fileManager = new FileManagerImpl();
        try {fileManager.writeString(string, FILEPATH);
        } catch (IOException ex) {
            throw new DAOException("Ошибка записи в файл: " + FILEPATH, ex);
        }
    }

    private List<Expense> loadExpenses(Checker checker) {
        FileManagerImpl fileManager = new FileManagerImpl();
        List<Expense> expenses = new ArrayList<>();
        List<String> strings;
        strings = fileManager.readStrings(checker, FILEPATH);
        ExpenseMapperImpl expenseMapper = new ExpenseMapperImpl();
        for (String string : strings) {
            expenses.add(expenseMapper.toExpense(string));
        }
        return expenses;
    }
}
