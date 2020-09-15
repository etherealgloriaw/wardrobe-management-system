package persistence;

import model.Clothing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// a reader that can read wardrobe contents from a file
public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of clothing parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<Clothing> readWardrobe(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of clothing parsed from list of strings
    // where each string contains data for one wardrobe
    private static List<Clothing> parseContent(List<String> fileContent) {
        List<Clothing> wardrobe = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            wardrobe.add(parseWardrobe(lineComponents));
        }

        return wardrobe;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 6 where element 0 represents the
    // type of the next clothing to be constructed, element 1 represents
    // the color, elements 2 represents the brand and element 3 represents
    // the price , element 4 represents the date
    // EFFECTS: returns an account constructed from components
    private static Clothing parseWardrobe(List<String> components) {
        String type = (components.get(0));
        String season = (components.get(1));
        String color = (components.get(2));
        String brand = (components.get(3));
        int price = Integer.parseInt(components.get(4));
        int date = Integer.parseInt(components.get(5));
        return new Clothing(type,season,color,brand,price,date);
    }
}