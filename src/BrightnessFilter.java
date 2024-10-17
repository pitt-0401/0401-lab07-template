/*
 * Created on 2026-02-26
 *
 * Copyright (c) 2026 Nadine von Frankenberg
 */

public class BrightnessFilter {

    /**
     * Brightens an image using gamma correction
     * See https://www.mathworks.com/help/images/gamma-correction.html
     *
     * @param pixelArray 3D pixel array [height][width][RGB]
     * @param intensity  0-100 (recommended: 10-30)
     */
    public static void applyBrightness(int[][][] pixelArray, int intensity) {
        float t = Math.max(0f, Math.min(1f, intensity / 100f));

        // gamma < 1 brightens. Map intensity to gamma in a stable range.
        // intensity 0 -> gamma 1.0 (no change)
        // intensity 100 -> gamma 0.55 (strong brighten)
        double gamma = 1.0 - 0.45 * t;

        int height = pixelArray.length;
        int width = pixelArray[0].length;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // TODO 2: retrieve the RGB array for the current pixel

                int r = gammaChannel(/* TODO access red value */, gamma);
                int g = gammaChannel(/* TODO access green value */, gamma);
                int b = gammaChannel(/* TODO access blue value */, gamma);

                // TODO 2: write the new RGB values back to the pixel array

            }
        }
    }

    // No need to touch the methods below!
    private static int gammaChannel(int value, double gamma) {
        double normalized = value / 255.0;
        double corrected = Math.pow(normalized, gamma);
        return clamp((int) Math.round(corrected * 255.0));
    }

    private static int clamp(int v) {
        return Math.max(0, Math.min(255, v));
    }
}
