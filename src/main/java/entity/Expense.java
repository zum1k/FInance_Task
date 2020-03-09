package entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

public class Expense extends Identifiable {
    private Calendar calendar;
    private ExpenseType expenseType;
    private BigDecimal cost;

    public Expense(int id, Calendar calendar, ExpenseType expenseType, BigDecimal cost) {
        this.setId(id);
        this.calendar = calendar;
        this.expenseType = expenseType;
        this.cost = cost;
    }

    public Expense() {
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Expense expense = (Expense) o;
        return Objects.equals(calendar, expense.calendar) &&
                expenseType == expense.expenseType &&
                Objects.equals(cost, expense.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), calendar, expenseType, cost);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "calendar=" + calendar +
                ", expenseType=" + expenseType +
                ", cost=" + cost +
                '}';
    }
}
