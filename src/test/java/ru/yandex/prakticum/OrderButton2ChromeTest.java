package ru.yandex.prakticum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderButton2ChromeTest {

    private WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void openPage() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement secondOrderButton1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'Home_FinishButton__1_cWm')]//button[contains(@class, 'Button_Middle__1CSJM')]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondOrderButton1);
        secondOrderButton1.click();


        WebElement nameField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input.Input_Responsible__1jDKN[placeholder='* Имя']")
        ));
        nameField.sendKeys("Иван");

        WebElement surnameField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input.Input_Responsible__1jDKN[placeholder='* Фамилия']")
        ));
        surnameField.sendKeys("Иванов");

        WebElement addressField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input.Input_Responsible__1jDKN[placeholder='* Адрес: куда привезти заказ']")
        ));
        addressField.sendKeys("Марченко 11");

        WebElement metroField = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder='* Станция метро']")
        ));
        metroField.click();

        // Ввод части названия станции для фильтрации
        metroField.sendKeys("Лубянка");

        // Выбор станции из списка
        WebElement station = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@class='select-search__row']//button[contains(.,'Лубянка')]")
        ));
        station.click();

        WebElement telephoneField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input.Input_Responsible__1jDKN[placeholder='* Телефон: на него позвонит курьер']")
        ));
        telephoneField.sendKeys("79985678888");

        driver.findElement(By.className("Button_Middle__1CSJM")).click();


        WebElement dateInputField = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder='* Когда привезти самокат']")
        ));
        dateInputField.click();  // Клик по полю ввода, чтобы открыть календарь

// Ждем пока календарь станет видимым
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("react-datepicker")
        ));

// Выбираем нужный день
        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='13']")
        ));
        day.click();

        WebElement rentalPeriodDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.Dropdown-root")
        ));
        rentalPeriodDropdown.click();

// Ждем появления вариантов в выпадающем списке
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'Dropdown-menu')]//div[contains(text(), 'сутки')]")

        ));
        option.click();

        //выбираем цвет самоката

        //нажимаем кнопку заказать
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and contains(text(), 'Заказать')]")
        ));
        orderButton.click();

        //нажимаем кнопку да
        WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and contains(text(), 'Да')]")
        ));
        yesButton.click();


        Thread.sleep(2000);
    }
}