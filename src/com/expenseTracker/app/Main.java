package com.expenseTracker.app;

import java.util.ArrayList;

class Main {

}
class Board {
    public Board() {

    }
}
class Expense {
    private ArrayList<String> title = new ArrayList<>();
    private short i = 0;
    public Expense(String title) {
        this.title.add(title);
        i++;
    }
}