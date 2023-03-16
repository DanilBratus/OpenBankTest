package org.exapmle.service;

import org.junit.jupiter.api.Assertions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AccordanceFilesByPixels implements AccordanceFiles {

    public void accordanceImages(String imageActuality, String imageExpected) {
        try {
            BufferedImage image1 = ImageIO.read(new File(pathFileActual + imageActuality));
            BufferedImage image2 = ImageIO.read(new File(pathFileExpect + imageExpected));

            System.out.println(image1);
            System.out.println(image2);

            if (image1.getHeight() != image2.getHeight() || image1.getWidth() != image2.getWidth()) {
                Assertions.fail("Images are different!");
            } else {
                int rows = image1.getHeight();
                int columns = image1.getWidth();

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < columns; col++) {
                        int rgb = image1.getRGB(col, row);
                        int rgb2 = image2.getRGB(col, row);

                        if (rgb != rgb2) {
                            Assertions.fail("Pixels image are different!");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
