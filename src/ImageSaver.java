/*
 * Created on 2026-10-09
 *
 * Copyright (c) 2026 Nadine von Frankenberg
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/******************************
 * NO NEED TO TOUCH THIS FILE *
 ******************************/

public final class ImageSaver {
    /**
     * Saves a BufferedImage as .png next to the original image
     * 
     * @param image     BufferedImage to be saved
     * @param inputPath Path of the original image
     * @return Location where the image was saved to
     * @throws IOException if the image cannot be written
     */
    public static String saveImage(BufferedImage image, String inputPath) throws IOException {
        String outputPath = buildOutputPath(inputPath);
        ImageIO.write(image, "png", new File(outputPath));
        return outputPath;
    }

    // pumpkin.png -> pumpkin-filtered.png, me.jpg -> me-filtered.png
    private static String buildOutputPath(String inputPath) {
        int dot = inputPath.lastIndexOf('.');
        String name = (dot > 0) ? inputPath.substring(0, dot) : inputPath;
        return name + "-filtered.png";
    }
}
