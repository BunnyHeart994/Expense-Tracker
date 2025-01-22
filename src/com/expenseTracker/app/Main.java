package com.expenseTracker.app;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static Scanner scan = new Scanner(System.in);
    private static ArrayList<Board> boardArrL = new ArrayList<>();
    private static Board board;
    //private ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        boolean entryPointFlag = true, secondFlag = true;
        short choice, currentBoard = 0, boardCount = 0, targetBoard, targetExpense;
        int monthlyWage, expenseCost;
        String boardName, expenseTitle, setActiveStr, tempExpense;

        Print.printLn("Expense Tracker v0.1 by Henrique\n");
        while (entryPointFlag) { //MAIN LOOP
            Print.print("=".repeat(10) + "MAIN MENU" + "=".repeat(10) + "\n" +
                    "1 - Create new board\n2 - Set active board\n3 - Delete board\n" +
                    "4 - Insert new expense\n5 - Remove expenses\n6 - List expenses\n" +
                    "0 - Exit\n" + "=".repeat(29) + "\n---> ");
            //1 - create new board
            //2 - set active board
            //3 - list boards
            //4 - delete board
            //5 - insert new expense
            //6 - remove expense
            //7 - list expenses
            choice = Short.parseShort(scan.nextLine());
            if (choice == 0) {
                Print.printLn("Thanks for using. Bye-bye.");
                secondFlag = false;
                break;
            } else if (choice == 1) {
                Print.printLn("_".repeat(29) + "\nBOARD CREATION\n" + "¨".repeat(29));
                Print.print("Enter the board name: ");
                boardName = scan.nextLine();
                Print.print("Enter the monthly wage: ");
                monthlyWage = Short.parseShort(scan.nextLine());
                boardArrL.add(new Board(boardName, monthlyWage));
                boardCount++;
                Print.printLn("You just created board No. " + boardCount +
                        " with the name '" + boardArrL.get(boardCount - 1).getName() + "'.");
                while (true) {
                    Print.print("Set newly created board as current active board? ('Y' or 'N')\n--> ");
                    setActiveStr = scan.nextLine();
                    if (setActiveStr.equalsIgnoreCase("y")) {
                        currentBoard = (short) (boardCount - 1);
                        Print.printLn("Board No. '" + (currentBoard + 1) + "' set to active.");
                        Print.printLn("*".repeat(29));
                        break;
                    } else if (setActiveStr.equalsIgnoreCase("n"))
                        break;
                    else Print.printLn("Invalid option. Try again.");
                }
            } else if (choice == 2) {
                Print.printLn("_".repeat(29) + "\nSET ACTIVE BOARD\n" + "¨".repeat(29));
                Board.listBoards(boardArrL);
                Print.print("Which board would you like to be focused?\n--> ");
                while (true) {
                    currentBoard = Short.parseShort(scan.nextLine());
                    if (currentBoard > boardArrL.size()) {
                        Print.print("There are only " + boardArrL.size() + " boards available.\n" +
                                "Try again.\n--> ");
                    } else if (currentBoard < 1) {
                        Print.print("Invalid number. Try again.\n--> ");
                    } else { currentBoard--; break; }
                }
                Print.printLn("Focusing board No. " + (currentBoard + 1) + ".\n" + "*".repeat(29));
            } else if (choice == 3) {
                Board.listBoards(boardArrL);
            } else if (choice == 4) {
                Print.printLn("_".repeat(29) + "\nDELETE BOARD\n" + "¨".repeat(29));
                while(true) {
                    Board.listBoards(boardArrL);
                    Print.print("Choose a board to remove: ");
                    short removalTarget = Short.parseShort(scan.nextLine());
                    removalTarget--;
                    if (removalTarget >= 0 && removalTarget < boardArrL.size()) {//TODO
                        boardArrL.remove(removalTarget);
                        Print.printLn("Board No. '" + (removalTarget + 1) + "' deleted.");
                        break;
                    } else {
                        Print.printLn("Board No. '" + removalTarget + "' doesn't exist. Try again.");
                    }
                }
            } else if (choice == 5) {
                while(true) {
                    if (boardCount == 1) {
                        Print.printLn("_".repeat(29) + "\nEXPENSE INSERTION"  + "¨".repeat(29));

                        Print.print("Board No. " + (currentBoard + 1) + " selected.\nExpense title: ");
                        expenseTitle = scan.nextLine();
                        Print.print("Cost: ");
                        expenseCost = Short.parseShort(scan.nextLine());
                        boardArrL.get(currentBoard).insertExpense(expenseTitle, expenseCost);
                        Print.printLn("'" + expenseTitle + "' added to board No. " + (currentBoard + 1) + ".");
                        Print.printLn("*".repeat(29));
                        break;
                    } else {
                        Print.print("_".repeat(29) + "\nTo which board will this expense belong to?\n--> ");
                        currentBoard = Short.parseShort(scan.nextLine());
                        currentBoard--;
                        if (currentBoard > boardArrL.size() - 1)
                            Print.printLn("There aren't more than " + boardArrL.size() + " boards.\n" +
                                    "Try again.");
                    }
                }
            } else if (choice == 6) {
                Print.printLn("_".repeat(29) + "\nDELETE EXPENSE\n" + "¨".repeat(29));
                if (boardCount > 1) {
                    Print.print("Which board does the expense belong to?\n--> ");
                    targetBoard = Short.parseShort(scan.nextLine());
                    //TODO
                } else if (boardCount == 1) {
                    Print.print("Board No. '" + currentBoard + "' selected.\n" +
                            "Which expense would you like to delete?\n--> ");
                    boardArrL.get(currentBoard).listExpenses();
                    targetExpense = Short.parseShort(scan.nextLine());
                    boardArrL.get(currentBoard).deleteExpense(targetExpense);
                    //TODO: add descriptive message
                }
            } else {
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
    protected Expense expense;

    public Board(String name, int monthlyWage) {
        this.name = name;
        this.monthlyWage = monthlyWage;
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
    protected static void listBoards(ArrayList<Board> arrList) {
        Print.print("Current boards: ");
        if (arrList.isEmpty())
            Print.printLn("NO BOARDS");
        else {
            for (short i = 0; i < arrList.size(); i++) {
                Print.print((i + 1) + " | ");
            }
            Print.printLn("\n");
        }
    }
    protected void listExpenses() {
        Print.print("Current expenses: ");
        if (expenses.isEmpty())
            Print.print("NO EXPENSES");
        else {
            for (short i = 0; i < expenses.size(); i++) {
                Print.print((i + 1) + " | ");
            }
            Print.printLn("\n");
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