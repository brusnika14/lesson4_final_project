package ru.yandex.prakticum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.prakticum.configurations.BaseConfiguration;
import ru.yandex.prakticum.configurations.MainPageConfiguration;

import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By orderButton = By.className(
            "Button_Button__ra12g"
    );
    private final By questionsBy = By.cssSelector(
            "[class*='accordion__heading']"
    );

    private final By orderButton2 = By.xpath(
            "//div[contains(@class, 'Home_FinishButton__1_cWm')]//button[contains(@class, 'Button_Middle__1CSJM')]"
    );

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, BaseConfiguration.IMPLICIT_WAIT);
    }


    public int getNumberOfQuestions() {
        List<WebElement> questions =  wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(
                    questionsBy
            )
        );
        return questions.size();
    }

    public boolean checkAnswerForQuestionByIndex(int index) {
        WebElement question = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("accordion__heading-" + index)
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", question);
        question.click();

        WebElement answer = driver.findElement(
                By.id("accordion__panel-" + index)
        );
        wait.until(ExpectedConditions.visibilityOf(answer));
        return answer.isDisplayed();
    }

    public void clickOnOrder() {
        driver.findElement(
            orderButton
        ).click();
    }

    public void clickOnOrder2() {
        WebElement secondOrderButton1 = wait.until(ExpectedConditions.elementToBeClickable(
                orderButton2
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondOrderButton1);
        secondOrderButton1.click();
    }

    public void openPage() {
        driver.get(MainPageConfiguration.BASE_URL);
    }

}
