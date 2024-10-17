/*
 * Created on 2026-02-26
 *
 * Copyright (c) 2026 Nadine von Frankenberg
 */

public final class ColorPalette {

    // prevent instantiation
    private ColorPalette() {
    }

    // final: the variable always refers to the same array
    // The values inside the array can still be changed
    public static final int[] SKY_BLUE = { 145, 220, 255 }; // rgb(145, 220, 255)
    public static final int[] NIGHT_SKY = { 25, 25, 60 }; // rgb(25, 25, 60)
    public static final int[] ORANGE = { 255, 140, 0 }; // rgb(255, 140, 0)
}
