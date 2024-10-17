/*
 * Created on 2026-10-09
 *
 * Copyright (c) 2026 Nadine von Frankenberg
 */

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/******************************
 * NO NEED TO TOUCH THIS FILE *
 ******************************/

public final class ImageLoader {

    // Larger photos are scaled down so the filters run faster
    private static final int MAX_SIZE = 1600;

    /**
     * Loads an image from a specified path
     * 
     * @param filePath Path to the image (.png or .jpg)
     * @return Loaded image as BufferedImage
     * @throws IOException if the file is missing or not a supported image
     */
    public static BufferedImage loadImage(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("File not found. Is it in the project folder?");
        }

        BufferedImage image = ImageIO.read(file);
        if (image == null) {
            throw new IOException("Unsupported image format. Please use .png or .jpg");
        }
        return toRgb(image);
    }

    // Removes transparency (-> white) and scales down large images
    private static BufferedImage toRgb(BufferedImage image) {
        double scale = Math.min(1.0, (double) MAX_SIZE / Math.max(image.getWidth(), image.getHeight()));
        int width = (int) Math.round(image.getWidth() * scale);
        int height = (int) Math.round(image.getHeight() * scale);

        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = result.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.drawImage(image, 0, 0, width, height, null);
        graphics.dispose();
        return result;
    }
}
