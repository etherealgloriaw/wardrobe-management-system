package persistence;

import model.Clothing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    private static final String TEST_FILE = "./data/testWardrobeFile1";
    private Writer testWriter;
    private Clothing clothing1;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        clothing1 = new Clothing("top", "spring", "white", "Levis", 100, 8);
    }

    @Test
    void testWriteAccounts() {
        // save clothing1 to file
        testWriter.write(clothing1);
        testWriter.close();

        // now read them back in and verify that the clothing have the expected values
        try {
            List<Clothing> wardrobe = Reader.readWardrobe(new File(TEST_FILE));
            Clothing clothing1 = wardrobe.get(0);
            assertEquals("top", clothing1.getType());
            assertEquals("spring", clothing1.getSeason());
            assertEquals("Levis", clothing1.getBrand());
            assertEquals("white", clothing1.getColor());
            assertEquals(100, clothing1.getPrice());
            assertEquals(8, clothing1.getDate());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}

