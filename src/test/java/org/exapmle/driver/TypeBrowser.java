package org.exapmle.driver;

import org.exapmle.driver.enums.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class TypeBrowser {
    public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    public static final String WEBDRIVER_EDGE_DRIVER = "webdriver.edge.driver";
    public static final String CHROMEDRIVER_EXE = "src/main/resources/web_driver/ChromeDriver/111_0_5563_64/chromedriver.exe";
    public static final String EDGEDRIVER_EXE = "src/main/resources/web_driver/EdgeDriver/111_0_1661_43/msedgedriver.exe";

    public static final Integer TIMEOUT = 1000;
    protected static WebDriver driver;

    private static void setChromeDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROMEDRIVER_EXE);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options.addArguments("--start-maximized").addArguments("--remote-allow-origins=*"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));
    }

    private static void setEdgeDriver() {
        System.setProperty(WEBDRIVER_EDGE_DRIVER, EDGEDRIVER_EXE);
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options.addArguments("--start-maximized").addArguments("--remote-allow-origins=*"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));
    }

    public static void setWebDriver(Driver driver) {
        switch (driver) {
            case CHROME: setChromeDriver();
            break;
            case EDGE: setEdgeDriver();
            break;
            default: setChromeDriver();
        }
    }
}
