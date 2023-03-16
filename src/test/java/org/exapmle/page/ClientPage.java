package org.exapmle.page;

import org.exapmle.driver.TypeBrowser;
import org.exapmle.driver.enums.Driver;
import org.exapmle.enums.ClientContainerHeader;
import org.exapmle.enums.ClientHeader;
import org.exapmle.service.AccordanceFiles;
import org.exapmle.service.DownloadFiles;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.exapmle.contant.ConstURL.CLIENT_URL;

public class ClientPage extends TypeBrowser {
    private static final By clientHref = By.xpath("//link[@rel = 'canonical']");
    private static final By imagesClientCash = By.xpath("//div[contains(@class, '7gYm2')]//img[@srcset]");

    public static void openBrowser(String url) {
        TypeBrowser.setWebDriver(Driver.EDGE);
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.close();
        driver.quit();
    }

    public static void checkAccordanceURL() {
        WebElement canonical =
                new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
                        .until(ExpectedConditions.presenceOfElementLocated(clientHref));
        String clientURL = canonical.getDomProperty("href");
        Assertions.assertEquals(clientURL, CLIENT_URL);
    }

    public static void clickClientHeaders(ClientHeader nameHeader) {
        driver.findElement(By.xpath("//div[contains(@class, '6loXt')]//div[text() = '" + nameHeader.getName() + "']")).click();
    }

    public static void clickClientContainerHeader(ClientContainerHeader containerHeader) {
        driver.findElement(By.xpath("//div[contains(@class, 'R5YVD')]//a[contains(text(), '" + containerHeader.getName() + "')]")).click();
    }

    public static void downloadImage() {
        String urlImage = driver.findElement(imagesClientCash).getDomProperty("currentSrc");
        DownloadFiles.download(urlImage, "imageLoanCash.png");
//        DownloadFiles.downloadImage(urlImage, "imageLoanCash.png");
    }

    public static void accordanceImage(AccordanceFiles accordanceFiles) {
        accordanceFiles.accordanceImages("imageLoanCash.png", "Image_loan_cash.png");
    }
}
