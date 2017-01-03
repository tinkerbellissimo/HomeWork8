/**
 * Created by tinkerbellissimo on 1/2/17.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

/**
 * Created by tinkerbellissimo on 12/29/16.
 */
public class Homework8 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/tinkerbellissimo/Downloads/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test() {
        driver.get("http://localhost/litecart/en/");

        int countItems = driver.findElements(cssSelector(".product")).size();
        List<WebElement> items;
        for (int i = 0; i < countItems; i++) {
            items=driver.findElements(cssSelector(".product"));
            System.out.println("Item sticker: "+items.get(i).getText());
            System.out.println(areElementsPresent (driver, By.cssSelector(".sticker")));
        }
    }

    boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

