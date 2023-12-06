package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColourTable {
    private final List<Integer> palette;
    private final int MAX_SIZE = 1024; // Maximum allowed size for the palette

    public ColourTable(int paletteSize) {
        if (!isValidPaletteSize(paletteSize)) {
            throw new IllegalArgumentException("Invalid palette size");
        }
        palette = new ArrayList<>(paletteSize);
    }

    public void add(int rgbColor) {
        if (palette.size() >= MAX_SIZE) {
            throw new IllegalStateException("Exceeded maximum capacity of the ColourTable");
        }

        // Check if the RGB color is valid (non-negative)
        if (rgbColor < 0) {
            throw new IllegalArgumentException("Invalid RGB color value");
        }

        palette.add(rgbColor);
    }

    public void remove(int rgbColor) {
        Iterator<Integer> iterator = palette.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == rgbColor) {
                iterator.remove();
                return;
            }
        }
        throw new IllegalArgumentException("Color not found in the palette");
    }

    private boolean isValidPaletteSize(int size) {
        return size > 0 && size <= MAX_SIZE && (size & (size - 1)) == 0; // Check if power of two
    }

    public List<Integer> getPalette() {
        return palette;
    }
}
