import org.example.ColourTable;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class ColourTableTest {

    @Test
    void testValidPaletteSize() {
        assertTrue(new ColourTable(2).getPalette().isEmpty());
        assertTrue(new ColourTable(4).getPalette().isEmpty());
        assertTrue(new ColourTable(8).getPalette().isEmpty());
        assertTrue(new ColourTable(1024).getPalette().isEmpty());
    }

    @Test
    void testInvalidPaletteSize() {
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(3));
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(1025));
    }

    @Test
    void testAddColor() {
        ColourTable colourTable = new ColourTable(4);
        colourTable.add(0xFF0000); // Red
        colourTable.add(0x00FF00); // Green
        colourTable.add(0x0000FF); // Blue
        colourTable.add(0xFFFFFF); // White

        List<Integer> palette = colourTable.getPalette();
        assertEquals(4, palette.size());
        assertEquals(0xFF0000, palette.get(0).intValue());
        assertEquals(0x00FF00, palette.get(1).intValue());
        assertEquals(0x0000FF, palette.get(2).intValue());
        assertEquals(0xFFFFFF, palette.get(3).intValue());
    }
    @Test
    void testInvalidRGBColor() {
        ColourTable colourTable = new ColourTable(4);

        // Attempt to add an invalid RGB color (negative value)
        assertThrows(IllegalArgumentException.class, () -> {
            // Use a negative RGB value, which should throw an exception
            colourTable.add(-1);
        });}

    @Test
    void testExceedCapacity() {
        ColourTable colourTable = new ColourTable(2);
        colourTable.add(0xFF0000); // Red
        colourTable.add(0x00FF00); // Green

        // Blue
    }
    @Test
    void testGetPaletteAfterAddingColors() {
        ColourTable colourTable = new ColourTable(3);
        colourTable.add(0xFF0000); // Red
        colourTable.add(0x00FF00); // Green
        colourTable.add(0x0000FF); // Blue

        List<Integer> palette = colourTable.getPalette();
        assertEquals(3, palette.size());
        assertTrue(palette.contains(0xFF0000));
        assertTrue(palette.contains(0x00FF00));
        assertTrue(palette.contains(0x0000FF));
    }

    @Test
    void testAddColorsBeyondCapacity() {
        ColourTable colourTable = new ColourTable(2);
        colourTable.add(0xFF0000); // Red
        colourTable.add(0x00FF00); // Green

        assertThrows(IllegalStateException.class, () -> {
            // Attempt to add another color beyond the capacity
            colourTable.add(0x0000FF); // Blue
        });
    }

    @Test
    void testGetPaletteWithNoColorsAdded() {
        ColourTable colourTable = new ColourTable(5);
        List<Integer> palette = colourTable.getPalette();
        assertTrue(palette.isEmpty());
    }
}
