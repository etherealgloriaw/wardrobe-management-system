package model;

import exceptions.OutOfDateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MyWardrobeTest {
    private MyWardrobe wardrobe1;

    @BeforeEach
    public void runBefore() {
        wardrobe1 = new MyWardrobe();
    }

    @Test
    public void testAddNewClothingSuccessfully() {
        try {
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        } catch (OutOfDateException e){
            fail("I was not expecting SomeException!");
        }
        assertEquals(100,wardrobe1.getMonthlySpending(8));
    }

    @Test
    public void testAddNewClothingFailed1() {
        try {
            wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                    100, 80);
            fail("I was not expecting to reach this line of code!");
        } catch (OutOfDateException e){
        }
        assertEquals(0,wardrobe1.getMonthlySpending(8));
    }

    @Test
    public void testAddNewClothingFailed2() {
        try {
            wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                    100, -10);
            fail("I was not expecting to reach this line of code!");
        } catch (OutOfDateException e){
        }
        assertEquals(0,wardrobe1.getMonthlySpending(8));
    }

    @Test
    public void testSearchType() throws OutOfDateException {
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        assertEquals(1,wardrobe1.search("top"));
        assertEquals(0,wardrobe1.search("outwear"));
    }

    @Test
    public void testSearchBrand() throws OutOfDateException {
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        assertEquals(1,wardrobe1.search("Levis"));
        assertEquals(0,wardrobe1.search("outwear"));
    }

    @Test
    public void testSearchColor() throws OutOfDateException {
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        assertEquals(1,wardrobe1.search("white"));
        assertEquals(0,wardrobe1.search("black"));
    }

    @Test
    public void testSearchSeason() throws OutOfDateException {
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        assertEquals(1,wardrobe1.search("spring"));
        assertEquals(0,wardrobe1.search("winter"));
    }

    @Test
    public void testSearchDate() throws OutOfDateException {
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        assertEquals(1,wardrobe1.searchDate(8));
        assertEquals(0,wardrobe1.searchDate(9));
    }


    @Test
    public void testGetTotalSpending() throws OutOfDateException {
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 10);
        assertEquals(200,wardrobe1.getTotalSpending());
    }

    @Test
    public void testProduceNewOutfits() throws OutOfDateException {
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        wardrobe1.addNewClothing("top", "spring", "black", "Levis",
                100, 8);
        assertFalse(wardrobe1.produceNewOutfits("spring"));
        assertFalse(wardrobe1.produceNewOutfits("winter"));
        wardrobe1.addNewClothing("shoes","spring",
                "black","Geox",150,6);
        wardrobe1.addNewClothing("trousers", "spring","navy",
                "Margaret Howell", 400,12);
        assertTrue(wardrobe1.produceNewOutfits("spring"));
    }

    @Test
    public void testShowMyWardrobe() throws OutOfDateException {
        assertEquals("", wardrobe1.showMyWardrobe());
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        assertEquals("Type: " + "top" + " Season: " + "spring" + " Colour: " + "white"
                + "\nBrand: " + "Levis" + " Price: " + 100 + " Buying date: " + 8
                + "\n", wardrobe1.showMyWardrobe());

    }

    @Test
    public void testGetWardrobeLog() throws OutOfDateException {
        assertEquals("", wardrobe1.getTempWardrobe());
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        wardrobe1.search("white");
        assertEquals("Type: " + "top" + " Season: " + "spring" + " Colour: " + "white"
                + "\nBrand: " + "Levis" + " Price: " + 100 + " Buying date: " + 8 + "\n", wardrobe1.getTempWardrobe());

    }

    @Test
    public void testLoadMyWardrobe() throws IOException, OutOfDateException {
        wardrobe1.loadMyWardrobe();
        assertEquals(100,wardrobe1.getMonthlySpending(8));
        assertEquals(170,wardrobe1.getMonthlySpending(2));
    }

    @Test
    public void testSaveMyWardrobe() throws IOException, OutOfDateException {
        wardrobe1.loadMyWardrobe();
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        wardrobe1.saveMyWardrobe();
        wardrobe1.loadMyWardrobe();
        assertEquals(200,wardrobe1.getMonthlySpending(8));
    }

    @Test
    public void testClearMyWardrobe() throws OutOfDateException {
        wardrobe1.addNewClothing("top", "spring", "white", "Levis",
                100, 8);
        assertEquals(100,wardrobe1.getMonthlySpending(8));
        wardrobe1.clearMyWardrobe();
        assertEquals(0,wardrobe1.getMonthlySpending(8));
    }


}