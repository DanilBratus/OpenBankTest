package org.exapmle.service;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadFiles {
    private final static String pathCatalogDownload = "src/main/resources/images/actual/";

    /**
     * Качает битый файл, из-за чего ошибка в AccordanceFiles
     */
    public static void downloadImage(String URL, String nameImage) {
        try (InputStream is = new BufferedInputStream(new URL(URL).openStream());
             ByteArrayOutputStream arrayOS = new ByteArrayOutputStream();
             OutputStream os = new FileOutputStream(pathCatalogDownload + nameImage)) {

            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = is.read(buffer)) != -1) {
                System.out.println("Buffer Read of length: " + length);
                arrayOS.write(buffer, 0, length);
            }
            os.write(arrayOS.toByteArray());

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void download(String URL, String nameImage) {
        try(ReadableByteChannel rbc = Channels.newChannel(new URL(URL).openStream());
            FileOutputStream fos = new FileOutputStream(pathCatalogDownload + nameImage)) {

            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
