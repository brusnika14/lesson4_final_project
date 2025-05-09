package ru.yandex.prakticum;

import org.junit.Before;
import org.junit.Test;
import ru.yandex.prakticum.pages.MainPage;
import static org.junit.Assert.assertTrue;

public class ImportantQuestionsTest extends BaseTest {
    private MainPage mainPage;

    @Before
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(driver);
    }

    @Test
    public void checkAllImportantQuestions() {
        mainPage.openPage();
        int numberOfQuestions = mainPage.getNumberOfQuestions();
        for (int i = 0; i < numberOfQuestions; i++) {
            assertTrue(
                    "Ответ не отобразился после клика на вопрос " + i,
                    mainPage.checkAnswerForQuestionByIndex(i)
            );
        }
    }
}