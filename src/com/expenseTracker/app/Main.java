package com.expenseTracker.app;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Print.printLn("Expense Tracker v0.1 by Henrique\n");
        Board testBoard = new Board("TEST", 4000);
        testBoard.insertExpense("TEST", 300);
        testBoard.printExpensesDebug();
    }
}
class Board {
    private String name;
    private int monthlyWage;
    private ArrayList<Expense> expenses = new ArrayList<>();
    public Expense expense;

    public Board(String name, int monthlyWage) {
        this.name = name;
        this.monthlyWage = monthlyWage;
    }

    public void insertExpense(String name, int cost) {
        this.expense = new Expense(name, cost);
        this.expenses.add(expense);
    }
    public void deleteExpense(short index) {
        this.expenses.remove(index);
    }
    public void printExpensesDebug() {
        for (short i = 0; i < expenses.size(); i++) {
            if (i == expenses.size() - 1)
                Print.printLn(expenses.get(i).getName());
            else
                Print.printLn(expenses.get(i).getName() + "\n");
        }
    }
}
class Expense {
    private String name;
    private int cost;

    public Expense(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
    public String getName() {
        return this.name;
    }
    public Expense addExpense(String name, int cost) {
        return new Expense(name, cost);
    }
}