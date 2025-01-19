package com.expenseTracker.app;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static Scanner scan = new Scanner(System.in);
    public static ArrayList<Board> boardArrL = new ArrayList<>();
    public static void main(String[] args) {
        boolean entryPoint = true;
        short choice;
        int monthlyWage;
        String boardName;

        while (entryPoint) { //MAIN LOOP
            Print.printLn("Expense Tracker v0.1 by Henrique\n");
            Print.print("Enter '1' to create a new expense board.\nEnter '0' to exit.\n---> ");
            choice = scan.nextShort();
            if (choice == 1) {
                Print.print("Enter the board name: ");
                boardName = scan.nextLine();
                Print.print("Enter the monthly wage: ");
                monthlyWage = scan.nextShort();
                boardArrL.add(new Board(boardName));
            }
        }
        /*testBoard.insertExpense("TEST", 300);
        testBoard.printExpensesDebug();
        testBoard.deleteExpense((short)0);*/
    }
    /*public static Board newBoard(String name) {
        boardArrL.add(new Board(name));
    }*/
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
    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public int getMonthlyWage() {
        return this.monthlyWage;
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
                Print.printLn(expenses.get(i).getName() + " - $" + expense.getCost());
            else
                Print.printLn(expenses.get(i).getName() + " - $" + expense.getCost() + "\n");
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
    public int getCost() {
        return this.cost;
    }
}