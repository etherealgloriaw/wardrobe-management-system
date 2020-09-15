package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spending {
    private List<Integer> monthlySpending;

    public Spending() {
        monthlySpending = new ArrayList<Integer>(Collections.nCopies(13, 0));
    }

    // MODIFIES: this
    // EFFECTS: set the selecting month spending
    public void setMonthlySpending(int date, int price) {
        monthlySpending.set(date, monthlySpending.get(date) + price);
    }

    // EFFECTS: get the selecting month spending
    public int getMonthlySpending(int month) {
        return monthlySpending.get(month);
    }

    // EFFECTS: get the total value of the wardrobe
    public int getTotalSpending() {
        int sum = 0;
        for (int i : monthlySpending) {
            sum += i;
        }
        return sum;
    }
}
