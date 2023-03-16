package org.exapmle.service;

@FunctionalInterface
public interface AccordanceFiles {
    String pathFileActual = "src/main/resources/images/actual/";
    String pathFileExpect = "src/main/resources/images/expect/";

    void accordanceImages(String imageActuality, String imageExpected);

}
