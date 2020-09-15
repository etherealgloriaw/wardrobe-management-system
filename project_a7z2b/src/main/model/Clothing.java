package model;

import persistence.Reader;
import persistence.Savable;

import java.io.PrintWriter;

// Represents each clothing
public class Clothing implements Savable {
    private String type;       // type of the clothing
    private String color;      // color of the clothing
    private String brand;      // brand of the clothing
    private int price;         // price of the clothing
    private int date;     // buying month of the clothing
    private String season;     // wearing season of the clothing

    // EFFECTS: constructs a clothing with details
    public Clothing(String type, String season, String color, String brand, int price, int date) {
        this.type = type;
        this.season = season;
        this.color = color;
        this.brand = brand;
        this.price = price;
        this.date = date;
    }


    // EFFECTS: returns the type of clothing
    public String getType() {
        return type;
    }

    // EFFECTS: returns the color of clothing
    public String getColor() {
        return color;
    }

    // EFFECTS: returns the brand of clothing
    public String getBrand() {
        return brand;
    }

    // EFFECTS: returns the price of clothing
    public int getPrice() {
        return price;
    }

    // EFFECTS: returns the date of buying
    public int getDate() {
        return date;
    }

    // EFFECTS: returns the wearing season of clothing
    public String getSeason() {
        return season;
    }


    // EFFECTS: returns the details of clothing in string
    // for example:
    // "type: top season: spring colour: white
    // brand: levis price: 100 buying date: 10"
    public String showOneClothing() {
        return ("Type: " + this.getType() + " Season: " + this.getSeason() + " Colour: " + this.getColor()
                + "\nBrand: " + this.getBrand() + " Price: " + this.getPrice() + " Buying date: " + this.getDate()
                + "\n");
    }

    // EFFECTS: save the clothing to file
    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(type);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(season);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(color);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(brand);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(price);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(date);
    }

}
