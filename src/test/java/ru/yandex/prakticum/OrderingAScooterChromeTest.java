package ru.yandex.prakticum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.prakticum.pages.MainPage;
import ru.yandex.prakticum.pages.OrderPage;

public class OrderingAScooterChromeTest {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;
    @Before
    public void StartUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }
    @Test
    public void openPage() throws InterruptedException {
        mainPage.openPage();
        mainPage.clickOnOrder();
        orderPage.fillInTheNameField();
        orderPage.fillInLastNameField();
        orderPage.fillInAddressField();
        orderPage.clickMetro();
        orderPage.choiceMetro();
        orderPage.enterTelephone();
        orderPage.clickFurther1();
        orderPage.clickOpenTheCalendar();
        orderPage.openCalendar();
        orderPage.choiceDayInCalendar();
        orderPage.clickRent();
        orderPage.clickRentalPeriod();
        orderPage.color();
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}