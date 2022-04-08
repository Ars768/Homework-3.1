import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

public class WebDriverProjectTest {
    public static WebDriver driver;

    @BeforeClass
    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public static void navigation(){
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        var elem1 = driver.findElement(By.name("firstname"));
        elem1.sendKeys("Arsen");

        var elem2 = driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div/div/h2[2]/div[1]/div/div[5]/input"));
        elem2.sendKeys("Petrosyan");

        var elem3 = driver.findElement(By.id("sex-0"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", elem3);

        var elem4 = driver.findElement(By.cssSelector("#exp-1"));
        elem4.click();

        var elem5 = driver.findElement(By.cssSelector("#post-body-3077692503353518311 > div:nth-child(1) > div > div > h2:nth-child(1) > b > span"));
        System.out.println(elem5.getText());
    }
}
