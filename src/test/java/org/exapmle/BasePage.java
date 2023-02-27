package org.exapmle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.exapmle.contant.Constant.*;

public class BasePage {
    protected static WebDriver driver;

    @BeforeEach
    public void start() {
        System.setProperty(WEB_DRIVER, CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));
    }

    @AfterEach
    public void end() {
        driver.close();
        driver.quit();
    }
}
