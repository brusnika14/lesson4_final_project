package ru.yandex.prakticum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    @Before
    public void setUp() {
        // Получаем значение браузера из системной переменной (по умолчанию chrome)
        String browserName = System.getProperty("browser", "firefox").toLowerCase();

        // Инициализируем соответствующий драйвер
        switch (browserName) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}