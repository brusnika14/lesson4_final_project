package ru.yandex.prakticum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.prakticum.configurations.MainPageConfiguration;

public class MainPage {
    private final WebDriver driver;
    private final By orderButton = By.className(
            "Button_Button__ra12g"
    );

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnOrder() {
        driver.findElement(
            orderButton
        ).click();
    }

    public void openPage() {
        driver.get(MainPageConfiguration.BASE_URL);
    }

}
