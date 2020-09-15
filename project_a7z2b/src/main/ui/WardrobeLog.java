package ui;

import model.MyWardrobe;

import java.awt.*;
import javax.swing.*;

//GUI of the application
public class WardrobeLog {
    private static JFrame frame;
    private static JMenu menu;
    private MyWardrobe wardrobe;
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTextArea output;

    //Initialize the application
    public WardrobeLog() {
        super();
        wardrobe = new MyWardrobe();
        menu = new JMenu("wardrobe menu");
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("WardrobeLog");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        frame.setContentPane(createContentPane());
        frame.setJMenuBar(createMenuBar());

        //Display the window.
        frame.setSize(450, 700);
        frame.setVisible(true);
    }

    //EFFECT: create the gui
    public Container createContentPane() {
        //Create the content-pane-to-be.
        contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(50, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

    //build the menu bar
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        AddTool addtool = new AddTool(wardrobe,frame,output);
        LoadTool loadtool = new LoadTool(wardrobe,frame,output);
        SaveTool savetool = new SaveTool(wardrobe,frame,output);
        SearchTool searchTool = new SearchTool(wardrobe,frame,output);
        SpendingTool spendingtool = new SpendingTool(wardrobe,frame,output);
        InspirationTool inspirationtool = new InspirationTool(wardrobe,frame,output);
        addtool.createItem(menu);
        loadtool.createItem(menu);
        savetool.createItem(menu);
        searchTool.createItem(menu);
        spendingtool.createItem(menu);
        inspirationtool.createItem(menu);
        menuBar.add(menu);
        return menuBar;
    }


    //creating and showing this application's GUI.
    public static void main(String[] args) {
        new WardrobeLog();
    }
}
