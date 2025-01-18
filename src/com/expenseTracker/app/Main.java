package com.expenseTracker.app;

import java.util.ArrayList;
//import com.expenseTracker.*;

class Main {
    public static void main(String[] args) {
        Print.printLn("Expense Tracker v0.1 by Henrique\n");

    }
}
class Board {
    private ArrayList<Expense> expenses;

    public Board(ArrayList<Expense> expenseArrL, String name) {

    }
    public void addExpense(Expense expense, String name, int cost) {
        this.expenses = expenses.add();
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