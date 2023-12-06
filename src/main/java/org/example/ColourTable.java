package org.example;

import java.util.ArrayList;
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
        palette.add(rgbColor);
    }

    private boolean isValidPaletteSize(int size) {
        return size > 1 && size <= MAX_SIZE && (size & (size - 1)) == 0; // Check if power of two
    }

    public List<Integer> getPalette() {
        return palette;
    }
}
