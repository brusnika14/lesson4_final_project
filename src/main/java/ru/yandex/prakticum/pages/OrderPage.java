package ru.yandex.prakticum.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.prakticum.configurations.BaseConfiguration;
import ru.yandex.prakticum.configurations.OrderPageConfiguration;
import ru.yandex.prakticum.models.User;

public class OrderPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final User user;
    private final String station;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, BaseConfiguration.IMPLICIT_WAIT);
        user = OrderPageConfiguration.getRandomUser();
        station = OrderPageConfiguration.getStation();
    }

    public String getOrderStatusText() {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("Track_Order__1S6E9")
        ));
        return webElement.getText();
    }

    public void clickStatus() {
        WebElement statusButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Посмотреть статус')]")
        ));
        statusButton.click();

    }


    public void clickYesButton() {
        WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and contains(text(), 'Да')]")
        ));
        yesButton.click();
    }

    public void clickOrderButton() {
        //нажимаем кнопку заказать
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and contains(text(), 'Заказать')]")
        ));
        orderButton.click();
    }
    public void color() {
        driver.findElement(By.id("black")).click();
    }

    public void clickRentalPeriod() {
        // Ждем появления вариантов в выпадающем списке
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'Dropdown-menu')]//div[contains(text(), 'сутки')]")

        ));
        option.click();
    }

    public void clickRent() {
        WebElement rentalPeriodDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.Dropdown-root")
        ));
        rentalPeriodDropdown.click();
    }

    public void choiceDayInCalendar() {
        // Выбираем нужный день
        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='13']")
        ));
        day.click();
    }

    public void openCalendar() {
        // Ждем пока календарь станет видимым
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("react-datepicker")
        ));
    }

    public void clickOpenTheCalendar() {
        WebElement dateInputField = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder='* Когда привезти самокат']")
        ));
        dateInputField.click();  // Клик по полю ввода, чтобы открыть календарь
    }

    public void clickFurther1() {
        driver.findElement(By.className("Button_Middle__1CSJM")).click();
    }

    public void enterTelephone() {
        WebElement telephoneField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input.Input_Responsible__1jDKN[placeholder='* Телефон: на него позвонит курьер']")
        ));
        telephoneField.sendKeys(user.getPhoneNumber());
    }

    public void choiceMetro() {
        // Выбор станции из списка

        WebElement stationElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(
                        String.format(
                                "//li[@class='select-search__row']//button[contains(.,'%s')]",
                                station
                        )
        )));
        stationElement.click();
    }

    public void clickMetro() {
        WebElement metroField = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[placeholder='* Станция метро']")
        ));
        metroField.click();

        // Ввод части названия станции для фильтрации
        metroField.sendKeys(station);
    }

    public void fillInAddressField() {
        WebElement addressField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input.Input_Responsible__1jDKN[placeholder='* Адрес: куда привезти заказ']")
        ));
        addressField.sendKeys(user.getAddress());
    }

    public void fillInLastNameField() {
        WebElement surnameField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input.Input_Responsible__1jDKN[placeholder='* Фамилия']")
        ));
        surnameField.sendKeys(user.getLastName());
    }

    public void fillInTheNameField() {
        WebElement nameField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input.Input_Responsible__1jDKN[placeholder='* Имя']")
        ));
        nameField.sendKeys(user.getFirstName());
    }
}
