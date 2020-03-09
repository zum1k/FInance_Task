package dao.mapper.impl;
import dao.mapper.ExpenseMapper;
import entity.Expense;
import entity.ExpenseType;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExpenseMapperImplTest {
   @Test
   public void toString_Expense_String(){
       //given
       ExpenseMapper expenseMapper = new ExpenseMapperImpl();
       int id = 1;
       Calendar calendar = new GregorianCalendar(2020, 2, 9);
       ExpenseType expenseType = ExpenseType.FOOD;
       BigDecimal bigDecimal = new BigDecimal(15);
       Expense expense = new Expense(id, calendar, expenseType, bigDecimal);
       //when
       String result = expenseMapper.toString(expense);
       //then
       Assert.assertEquals("1 2020.03.09 FOOD 15", result);
   }
   @Test
   public void toExpense_String_Expense(){
       //given
       ExpenseMapper expenseMapper = new ExpenseMapperImpl();
       String value = "1 2020.03.09 FOOD 15";
       int id = 1;
       Calendar calendar = new GregorianCalendar(2020, 2, 9);
       ExpenseType expenseType = ExpenseType.FOOD;
       BigDecimal bigDecimal = new BigDecimal(15);
       Expense expense = new Expense(id, calendar, expenseType, bigDecimal);

       //when
       Expense result = expenseMapper.toExpense(value);

       //then
       Assert.assertEquals(expense, result);
   }

}
