package service;

import dao.impl.ExpenseDAOImpl;
import dao.mapper.ExpenseMapper;
import dao.mapper.impl.ExpenseMapperImpl;
import entity.Expense;
import entity.ExpenseType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ClientService {

    public List<String> getAllExpenseType(int id, ExpenseType expenseType) {
        ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl(id);
        List<Expense> expenses= expenseDAO.getAllByType(expenseType);
       return loadService(expenses);

    }

    public List<String> getAllExpenseTypeFrom(int id, ExpenseType expenseType, Calendar date) {
        ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl(id);
        List<Expense> expenses= expenseDAO.getAllByExpenseTypeFromDate(expenseType, date);
        return loadService(expenses);
    }

    public List<String> getAllExpenseTypeFromTo(int id, ExpenseType expenseType, Calendar date1, Calendar date2) {
        ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl(id);
        List<Expense> expenses= expenseDAO.getAllExpenseTypeFromTo(expenseType,date1, date2);
        return loadService(expenses);
    }

    public List<String> getAllExpenseTypeByDate(int id, ExpenseType expenseType, Calendar date) {
        ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl(id);
        List<Expense> expenses= expenseDAO.getAll();
        return loadService(expenses);
    }

    public List<String> getAll(int id) {
        ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl(id);
        List<Expense> expenses= expenseDAO.getAll();
        return loadService(expenses);
    }

    public List<String> getAllFrom(int id, Calendar date) {
        ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl(id);
        List<Expense> expenses= expenseDAO.getAllFrom(date);
        return loadService(expenses);
    }

    public List<String> getAllFromTo(int id, Calendar date1, Calendar date2) {
        ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl(id);
        List<Expense> expenses= expenseDAO.getAllFromTo(date1, date2);
        return loadService(expenses);
    }

    public List<String> getAllByDate(int id, Calendar date) {
        ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl(id);
        List<Expense> expenses= expenseDAO.getAllByDate(date);
        return loadService(expenses);
    }

    public void setExpense(int id, Calendar date, ExpenseType expenseType, BigDecimal cost) {
        ExpenseMapperImpl expenseMapper = new ExpenseMapperImpl();
        ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl(id);
        expenseDAO.setExpense(id, date, expenseType, cost);
    }

    private String sum(List<Expense> expenses){
        int res = 0;
        for (Expense e:expenses){
           res += e.getCost().intValue();
        }
        return "sum = "+res;
    }
    private List<String> loadService(List<Expense> expenses){
        List<String> strings = new ArrayList<>();
        ExpenseMapper expenseMapper = new ExpenseMapperImpl();
        for (Expense e:expenses) {
            strings.add(expenseMapper.toString(e));
        }
        strings.add(sum(expenses));
        return strings;
    }
}
