package persistence;

import model.Clothing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ReaderTest {
    private Reader testReader;

    @BeforeEach
    void runBefore() {
        Reader testReader = new Reader();
    }


    @Test
    void testParseClothingFile1() {
        try {
            List<Clothing> wardrobe = Reader.readWardrobe(new File("./data/testWardrobeFile2.txt"));
            Clothing clothing1 = wardrobe.get(0);
            assertEquals("top", clothing1.getType());
            assertEquals("spring", clothing1.getSeason());
            assertEquals("simone rocha", clothing1.getBrand());
            assertEquals("red", clothing1.getColor());
            assertEquals(170, clothing1.getPrice());
            assertEquals(2, clothing1.getDate());

            Clothing clothing2 = wardrobe.get(1);
            assertEquals("trousers", clothing2.getType());
            assertEquals("fall", clothing2.getSeason());
            assertEquals("margaret howell", clothing2.getBrand());
            assertEquals("navy", clothing2.getColor());
            assertEquals(400, clothing2.getPrice());
            assertEquals(12, clothing2.getDate());


        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }


    @Test
    void testIOException() {
        try {
            Reader.readWardrobe(new File("./data/testWardrobeFile3.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}

