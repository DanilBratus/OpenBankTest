package org.exapmle.test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.exapmle.enums.ClientContainerHeader;
import org.exapmle.enums.ClientHeader;
import org.exapmle.page.ClientPage;
import org.exapmle.service.AccordanceFilesByPixels;
import org.junit.jupiter.api.*;

import static org.exapmle.contant.ConstURL.CLIENT_URL;

public class TestClient {

    @Test
    @Owner("Данил Братусь")
    @DisplayName("Проверка URL")
    @Description("Первоначальная проверка соответствия URL сайта")
    public void testAccordanceURL() {
        ClientPage.openBrowser(CLIENT_URL);
        ClientPage.checkAccordanceURL();
        ClientPage.closeBrowser();
    }

    @Test
    @Owner("Данил Братусь")
    @DisplayName("Проверка кликабельности подменю 'Частным клиентам'")
    @Description("1. Открытие сайта 'Банк Открытие' \n" +
            "2. Клик 'Кредиты' в подменю 'Частным клиентам'\n" +
            "3. Клик 'Потребительские кредиты' в контейнере 'Кредиты'\n" +
            "4. Закрытие браузера")
    public void testClickedHeaderAndContainerHeader() {
        ClientPage.openBrowser(CLIENT_URL);
        ClientPage.clickClientHeaders(ClientHeader.LOANS);
        ClientPage.clickClientContainerHeader(ClientContainerHeader.CONSUMERS_LOANS);
        ClientPage.closeBrowser();
    }

    @Nested
    @DisplayName("Проверка соответствия картинки в подменю 'Частным клиентам'")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class TestImage {

        @Test
        @Order(1)
        @Owner("Данил Братусь")
        @DisplayName("Открытие сайта 'Банк Открытие'")
        public void openBrowser() {
            ClientPage.openBrowser(CLIENT_URL);
        }

        @Test
        @Order(2)
        @Owner("Данил Братусь")
        @DisplayName("Переход в подменю")
        public void clickHeaderClient() {
            ClientPage.clickClientHeaders(ClientHeader.LOANS);
        }

        @Test
        @Order(3)
        @Owner("Данил Братусь")
        @DisplayName("Скачивание картинки в подменю")
        public void downloadImage() {
            ClientPage.downloadImage();
        }

        @Test
        @Order(4)
        @Owner("Данил Братусь")
        @DisplayName("Проверка картинки")
        public void assertionsImage() {
            ClientPage.accordanceImage(new AccordanceFilesByPixels());
        }

        @Test
        @Order(5)
        @Owner("Данил Братусь")
        @DisplayName("Закрытие браузера")
        public void closeBrowser() {
            ClientPage.closeBrowser();
        }
    }

























/**
 * Хахахаа!!!
 * Мучался почему не работает, а оказывается logo не кликабельно)))
 *
 * */
//    @Test
//    @Owner("Danil Bratus")
//    @Description("Проверка кликабедьности LOGO и возврат на главную страницу")
//    public void backToMainPage() {
//        client = new ClientPage();
//        client.openBrowser(CLIENT_URL);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
//
//        WebElement finInstrument =
//                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'open-ui-tabs open-ui-tabs-light']/span[4]")));
//        finInstrument.click();
//
//        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'logo')]")));
////        label.click();
//
//        WebElement hrefMine =
//                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//link[@rel = 'canonical']")));
//        String mainURL = hrefMine.getDomProperty("href");
//
//        driver.quit();
//
////        Assert.assertEquals(mainURL, MAIN_URL);
//        Assertions.assertTrue(true);
//    }
//
//    @Test
//    @Owner("Danil Bratus")
//    @Description("Проверка открытия главной страницы по вкладке через сторонюю вкладку")
//    public void beckToMainPageThroughAboutTheBank() {
//        System.setProperty(WEB_DRIVER, CHROMEDRIVER_EXE);
//
//        WebDriver driver = new ChromeDriver();
//        driver.get(CLIENT_URL);
//        driver.manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
//
//        WebElement aboutTheBank =
//                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text() = 'О банке']")));
//        aboutTheBank.click();
//
//        WebElement deliveryWindow =
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Общая информация']")));
//        deliveryWindow.click();
//
//        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'icon']")));
//        label.click();
//
//        String href = driver.getCurrentUrl();
//
//        driver.quit();
//
//        Assertions.assertEquals(href, CLIENT_URL);
//    }
//
//    @Test
//    @Owner("Danil Bratus")
//    @Description("Проверка открытия карты офисы")
//    public void openOfficeAndScreen() {
//        System.setProperty(WEB_DRIVER, CHROMEDRIVER_EXE);
//
//        WebDriver driver = new ChromeDriver();
//        driver.get(CLIENT_URL);
//        driver.manage().window().maximize();
//
//        WebElement officePenza = (new WebDriverWait(driver, Duration.ofSeconds(1000))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Офисы']"))));
//        officePenza.click();
//
//        driver.manage().window().fullscreen();
//        driver.quit();
//    }
//
//    @Test
//    @Owner("Danil Bratus")
//    @Description("Проверка работы поиска")
//    public void openSearchToDepositReliable() {
//        System.setProperty(WEB_DRIVER, CHROMEDRIVER_EXE);
//
//        WebDriver driver = new ChromeDriver();
//        driver.get(CLIENT_URL);
//        driver.manage().window().maximize();
//
//        WebElement search = driver.findElement(By.xpath("//div[@class = 'HeaderSearch_search-icon__Y1fgh']"));
//        search.click();
//
//        WebElement input = (new WebDriverWait(driver, Duration.ofSeconds(1000)))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class, 'open-ui-search-input')]")));
//        input.sendKeys("Надежный", Keys.ENTER);
//
//        WebElement nadezhniy = (new WebDriverWait(driver, Duration.ofSeconds(1000)))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Вклад «Надежный» ']/../following-sibling::div/a")));
//
//        WebElement buttonCooke = driver.findElement(By.xpath("//div[@class='cookies-agreement']//button"));
//        buttonCooke.click();
//
//        Actions actions = new Actions(driver);
//        actions.click(buttonCooke).build();
//        Actions actions1 = new Actions(driver);
//        actions1.click(nadezhniy).build().perform();
//
//        WebElement headerText = (new WebDriverWait(driver, Duration.ofSeconds(1000)))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
//        String text = headerText.getText();
//
//        driver.quit();
//        Assertions.assertEquals(text, "ВКЛАД «НАДЕЖНЫЙ»");
//    }
}
