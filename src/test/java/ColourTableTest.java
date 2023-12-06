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
    void testExceedCapacity() {
        ColourTable colourTable = new ColourTable(2);
        colourTable.add(0xFF0000); // Red
        colourTable.add(0x00FF00); // Green

        assertThrows(IllegalStateException.class, () -> colourTable.add(0x0000FF)); // Blue
    }
}
