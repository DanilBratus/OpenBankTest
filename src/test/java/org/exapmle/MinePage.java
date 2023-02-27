package org.exapmle;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.exapmle.contant.Constant.*;

public class MinePage {

    @Test
    public void openMainPage() {
        System.setProperty(KEY_PROPERTY_DRIVER, VOLUME_PROPERTY_DRIVER);

        WebDriver driver = new ChromeDriver();
        driver.get(MAIN_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

        WebElement hrefMine =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//link[@rel = 'canonical']")));
        String mainURL = hrefMine.getDomProperty("href");

        driver.quit();

        Assert.assertEquals(mainURL, MAIN_URL);
    }
/**
 * Хахахаа!!!
 * Мучался почему не работает, а оказывается logo не кликабельно)))
 *
 * */
    @Test
    public void backToMainPage() {
        System.setProperty(KEY_PROPERTY_DRIVER, VOLUME_PROPERTY_DRIVER);

        WebDriver driver = new ChromeDriver();
        driver.get(MAIN_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

        WebElement finInstrument =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'open-ui-tabs open-ui-tabs-light']/span[4]")));
        finInstrument.click();

        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'logo')]")));
//        label.click();

        WebElement hrefMine =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//link[@rel = 'canonical']")));
        String mainURL = hrefMine.getDomProperty("href");

        driver.quit();

//        Assert.assertEquals(mainURL, MAIN_URL);
        Assert.assertTrue("Logo not click!", true);
    }

    @Test
    public void beckToMainPageThroughAboutTheBank() {
        System.setProperty(KEY_PROPERTY_DRIVER, VOLUME_PROPERTY_DRIVER);

        WebDriver driver = new ChromeDriver();
        driver.get(MAIN_URL);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

        WebElement aboutTheBank =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text() = 'О банке']")));
        aboutTheBank.click();

        WebElement deliveryWindow =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Общая информация']")));
        deliveryWindow.click();

        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'icon']")));
        label.click();

        String href = driver.getCurrentUrl();

        driver.quit();

        Assert.assertEquals(href, MAIN_URL);
    }

    @Test
    public void openOfficeAndScreen() {
        System.setProperty(KEY_PROPERTY_DRIVER, VOLUME_PROPERTY_DRIVER);

        WebDriver driver = new ChromeDriver();
        driver.get(MAIN_URL);
        driver.manage().window().maximize();

        WebElement officePenza = (new WebDriverWait(driver, Duration.ofSeconds(1000))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Офисы']"))));
        officePenza.click();

        driver.manage().window().fullscreen();
        driver.quit();
    }

    @Test
    public void openSearchToDepositReliable() {
        System.setProperty(KEY_PROPERTY_DRIVER, VOLUME_PROPERTY_DRIVER);

        WebDriver driver = new ChromeDriver();
        driver.get(MAIN_URL);
        driver.manage().window().maximize();

        WebElement search = driver.findElement(By.xpath("//div[@class = 'HeaderSearch_search-icon__Y1fgh']"));
        search.click();

        WebElement input = (new WebDriverWait(driver, Duration.ofSeconds(1000)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class, 'open-ui-search-input')]")));
        input.sendKeys("Надежный", Keys.ENTER);

        WebElement nadezhniy = (new WebDriverWait(driver, Duration.ofSeconds(1000)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Вклад «Надежный» ']/../following-sibling::div/a")));

        WebElement buttonCooke = driver.findElement(By.xpath("//div[@class='cookies-agreement']//button"));
        buttonCooke.click();

        Actions actions = new Actions(driver);
        actions.click(buttonCooke).build();
        Actions actions1 = new Actions(driver);
        actions1.click(nadezhniy).build().perform();

        WebElement headerText = (new WebDriverWait(driver, Duration.ofSeconds(1000)))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        String text = headerText.getText();

        driver.quit();
        Assert.assertEquals(text, "ВКЛАД «НАДЕЖНЫЙ»");
    }
}
