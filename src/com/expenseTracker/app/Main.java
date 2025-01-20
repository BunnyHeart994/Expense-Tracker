package com.expenseTracker.app;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static Scanner scan = new Scanner(System.in);
    private static ArrayList<Board> boardArrL = new ArrayList<>();
    //private ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        boolean entryPointFlag = true, secondFlag = true;
        short choice, currentBoard = -1;
        int monthlyWage, expenseCost;
        String boardName, expenseTitle;

        Print.printLn("Expense Tracker v0.1 by Henrique\n");
        while (entryPointFlag) { //MAIN LOOP
            Print.print("=".repeat(10) + "MAIN MENU" + "=".repeat(10) + "\n" +
                    "1 - Create new board\n2 - Insert new expense\n" + "3 - Delete expense\n" +
                            "4 - List expenses\n0 - Exit\n" + "=".repeat(29) + "\n---> ");

            choice = Short.parseShort(scan.nextLine());
            if (choice == 0) {
                Print.printLn("Thanks for using. Bye-bye.");
                secondFlag = false;
                break;
            }
            else if (choice == 1) {
                Print.print("Enter the board name: ");
                boardName = scan.nextLine();
                Print.print("Enter the monthly wage: ");
                monthlyWage = Short.parseShort(scan.nextLine());
                boardArrL.add(new Board(boardName, monthlyWage));
                currentBoard++;
                Print.printLn("You just created board No. " + currentBoard +
                        " with the name '" + boardArrL.get(currentBoard).getName() + "'.");
                continue;
            }
            else if (choice == 2) {
                Print.print("Expense title: ");
                expenseTitle = scan.nextLine();
                Print.print("Cost: ");
                expenseCost = Short.parseShort(scan.nextLine());
                boardArrL.get(currentBoard).insertExpense(expenseTitle, expenseCost);
                Print.printLn("'" + expenseTitle + "' added to board No. " + currentBoard + ".");
                continue;
            }
            else {
                Print.printLn("Invalid option. Try again.");
                secondFlag = false;
            }
            while (secondFlag) {
                
            }
        }
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
    /*public Board(String name) {
        this.name = name;
    }*/

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