package ru.yandex.prakticum;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.prakticum.pages.MainPage;
import ru.yandex.prakticum.pages.OrderPage;

public class OrderingAScooterTest extends BaseTest {
    private MainPage mainPage;
    private OrderPage orderPage;

    @Before
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    @Test
    public void openPage() {
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
        orderPage.clickStatus();
    }
}