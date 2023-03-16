package org.exapmle.service;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AccordanceFilesByBytes implements AccordanceFiles {
    public void accordanceImages(String imageActuality, String imageExpected) {
        try {
            byte[] image1 = Files.readAllBytes(Paths.get(pathFileActual + imageActuality));
            byte[] image2 = Files.readAllBytes(Paths.get(pathFileExpect + imageExpected));

            if (image1.length == image2.length) {
                Assertions.assertArrayEquals(image1, image2);
            } else {
                Assertions.fail("Images are different!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
