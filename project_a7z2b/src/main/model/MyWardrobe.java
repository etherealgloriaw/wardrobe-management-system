package model;

import exceptions.OutOfDateException;
import persistence.Reader;
import persistence.Writer;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.List;

// Represents a grocery bill having a list of clothing
public class MyWardrobe extends Component {
    private List<Clothing> wardrobe;
    private List<Clothing> outfits;
    private List<String> temp;
    private Clothing newClothing;
    private static final String TEST_FILE = "./data/testWardrobeFile1";
    private Writer writer;
    private Spending monthlySpending;

    public MyWardrobe() {
        wardrobe = new ArrayList<>();
        temp = new ArrayList<>();
        monthlySpending = new Spending();
    }


    // MODIFIES: this, monthlySpending
    // EFFECTS: add a new clothing to wardrobe, throws OutOfDateException if the date is invalid
    public void addNewClothing(String type, String season, String color, String brand, int price, int date)
            throws OutOfDateException {
        if (date > 12 | date <= 0) {
            throw new OutOfDateException("please input a date between 1 and 12");
        } else {
            newClothing = new Clothing(type, season, color, brand, price, date);
            wardrobe.add(newClothing);
            monthlySpending.setMonthlySpending(date, price);
        }
    }

    // MODIFIES: this
    // EFFECTS: show the selecting types clothing and the total amount
    public int search(String condition) {
        temp.clear();
        for (Clothing c : wardrobe) {
            if (c.getType().equals(condition)) {
                temp.add(c.showOneClothing());
                continue;
            }
            if (c.getBrand().equals(condition)) {
                temp.add(c.showOneClothing());
                continue;
            }
            if (c.getColor().equals(condition)) {
                temp.add(c.showOneClothing());
                continue;
            }
            if (c.getSeason().equals(condition)) {
                temp.add(c.showOneClothing());
                continue;
            }
        }
        return temp.size();
    }

    // MODIFIES: this
    // EFFECTS: show the selecting dates of clothing and the total amount
    public int searchDate(int condition) {
        temp.clear();
        for (Clothing c : wardrobe) {
            if (c.getDate() == (condition)) {
                temp.add(c.showOneClothing());
            }
        }
        return temp.size();
    }


    // MODIFIES: this
    // EFFECTS: produce outfits from clothing with given season and return true if there is outfits
    public boolean produceNewOutfits(String season) {
        temp.clear();
        String type = "";
        outfits = new ArrayList<>();
        for (Clothing c : wardrobe) {
            if ((c.getSeason() == season) && (type != c.getType())) {
                outfits.add(c);
                type = c.getType();
            }
        }
        if (outfits.size() >= 2) {
            Collections.shuffle(wardrobe);
            for (Clothing c : outfits) {
                temp.add(c.showOneClothing());
            }
            return true;
        } else {
            return false;
        }
    }

    // MODIFIES: this
    // EFFECTS: load the clothing from the file to my wardrobe
    public void loadMyWardrobe() throws IOException, OutOfDateException {
        List<Clothing> loading = Reader.readWardrobe(new File(TEST_FILE));
        clearMyWardrobe();
        for (Clothing c : loading) {
            addNewClothing(c.getType(), c.getSeason(), c.getColor(), c.getBrand(), c.getPrice(), c.getDate());
        }
    }

    // MODIFIES: this
    // EFFECTS: show contents of my wardrobe
    public String showMyWardrobe() {
        String wardrobeString = "";
        for (Clothing c : wardrobe) {
            wardrobeString += (c.showOneClothing());
        }
        return wardrobeString;
    }

    // EFFECTS: save the from my wardrobe to the file
    public void saveMyWardrobe() throws FileNotFoundException, UnsupportedEncodingException {
        writer = new Writer(new File(TEST_FILE));
        for (Clothing c : wardrobe) {
            writer.write(c);
        }
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: make my wardrobe empty and set 0 to monthlySpending
    public void clearMyWardrobe() {
        wardrobe.clear();
        monthlySpending = new Spending();
    }

    // EFFECTS: get searching results
    public String getTempWardrobe() {
        String log = "";
        for (String i : temp) {
            log += i;
        }
        return log;
    }

    // EFFECTS: get the selecting month spending
    public int getMonthlySpending(int month) {
        return monthlySpending.getMonthlySpending(month);
    }

    // EFFECTS: get the total value of the wardrobe
    public int getTotalSpending() {
        return monthlySpending.getTotalSpending();
    }


}
