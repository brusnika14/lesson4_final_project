package ru.yandex.prakticum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ImportantQuestionsFirefoxTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkAllImportantQuestions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Получаем все вопросы
        List<WebElement> questions = driver.findElements(By.cssSelector("[class*='accordion__heading']"));

        for (int i = 0; i < questions.size(); i++) {
            WebElement question = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("accordion__heading-" + i)
            ));

            // Скролл и клик
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", question);
            question.click();

            // Проверяем, что соответствующий ответ раскрылся
            WebElement answer = driver.findElement(By.id("accordion__panel-" + i));
            wait.until(ExpectedConditions.visibilityOf(answer));
            assertTrue("Ответ не отобразился после клика на вопрос " + i, answer.isDisplayed());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}