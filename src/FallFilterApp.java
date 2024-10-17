/*
 * Created on 2026-10-09
 *
 * Copyright (c) 2026 Nadine von Frankenberg
 */

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class FallFilterApp {

    public static void main(String[] args) {
        // TODO 1a: Configure command line arguments to read in file names
        // Create a launch.json file & add "pumpkin.png" to the args
        // Reminder: Ensure proper error handling (what if there are no args?) with:
        // System.err.println("Failed to process " + inputPath + ": " + e.getMessage());

    }

    private static void processImage(String path) throws IOException {
        System.out.println(path);

        // Load the image
        BufferedImage originalImage = ImageLoader.loadImage(path);
        System.out.println("Image loaded successfully.");

        // TODO 1a: Convert image to 3D array
        // Make use of ImageProcessor.imageToArray
        // pixelArray = ... ;

        // Pumpkin only: change the sky and recolor the trees
        if (isPumpkin(path)) {
            // TODO 1b: Change the sky color from white to a new color
            // Define a newSkyColor, e.g., { 145, 220, 255 } (or use ColorPalette)

            // TODO 1b: Uncomment
            // ImageProcessor.changeSkyColor(pixelArray, newSkyColor);
            // System.out.println("Sky color changed: " + Arrays.toString(newSkyColor));

            // TODO 2: Recolor the trees (use FallEffect)
        }

        // Any image: filters and leaves
        // Optional: Define separate method(s) to apply the effects

        // TODO 2: Apply brightness filter (use BrightnessFilter)

        // TODO 2: Apply orange filter (use OrangeHueFilter)

        // TODO 2: Add leaves (use FallLeavesEffect)

        // Convert back to image
        BufferedImage modifiedImage = ImageProcessor.arrayToImage(pixelArray);

        // Save the modified image
        String outputPath = ImageSaver.saveImage(modifiedImage, path);
        System.out.println("Modified image saved as: " + outputPath);
    }

    private static boolean isPumpkin(String path) {
        return path.endsWith("pumpkin.png");
    }
}
