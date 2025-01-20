package com.expenseTracker.app;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static Scanner scan = new Scanner(System.in);
    private static ArrayList<Board> boardArrL = new ArrayList<>();
    //private ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        boolean entryPointFlag = true, secondFlag = true;
        short choice, currentBoard = -1, boardCount = 0;
        int monthlyWage, expenseCost;
        String boardName, expenseTitle, setActiveStr;

        Print.printLn("Expense Tracker v0.1 by Henrique\n");
        while (entryPointFlag) { //MAIN LOOP
            Print.print("=".repeat(10) + "MAIN MENU" + "=".repeat(10) + "\n" +
                    "1 - Create new board\n2 - Set active board\n3 - Insert new expense\n" +
                    "4 - Delete expense\n5 - List expenses\n0 - Exit\n" + "=".repeat(29) + "\n---> ");

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
                boardCount++;
                Print.printLn("You just created board No. " + boardCount +
                        " with the name '" + boardArrL.get(boardCount - 1).getName() + "'.");
                Print.print("Set newly created board as current active board? ('Y' or 'N')\n--> ");
                setActiveStr = scan.nextLine();
                if (setActiveStr.equalsIgnoreCase("y")) {
                    currentBoard = (short) (boardCount - 1);
                    Print.printLn("*".repeat(29));
                    continue;
                }
                else if (setActiveStr.equalsIgnoreCase("n"))
                    continue;
            }
            else if (choice == 2) {
                Print.printLn("_".repeat(29) + "\nSET ACTIVE BOARD");
                Print.print("Current boards: ");
                for (short i = 0; i < boardArrL.size(); i++) {
                    Print.print((i + 1) + " | ");
                }
                Print.print("\nWhich board would you like to be focused?\n--> ");
                currentBoard = Short.parseShort(scan.nextLine());
                currentBoard--;
                Print.printLn("Focusing board No. " + (currentBoard + 1) + ".\n" + "*".repeat(29));
            }
            else if (choice == 3) {
                while(true) {
                    if (currentBoard != -1) {
                        Print.printLn("_".repeat(29) + "\nEXPENSE INSERTION");

                        Print.print("Board No. " + (currentBoard + 1) + " selected.\nExpense title: ");
                        expenseTitle = scan.nextLine();
                        Print.print("Cost: ");
                        expenseCost = Short.parseShort(scan.nextLine());
                        boardArrL.get(currentBoard).insertExpense(expenseTitle, expenseCost);
                        Print.printLn("'" + expenseTitle + "' added to board No. " + (currentBoard + 1) + ".");
                        Print.printLn("*".repeat(29));
                        break;
                    }
                    else {
                        Print.print("_".repeat(29) + "\nTo which board will this expense belong to?\n--> ");
                        currentBoard = Short.parseShort(scan.nextLine());
                        currentBoard--;
                    }
                }
            }
            else if (choice == 4) {
                Print.print("");
            }
            else {
                Print.printLn("Invalid option. Try again.");
                Print.printLn("*".repeat(29));
                secondFlag = false;
            }
            /*while (secondFlag) {

            }*/
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