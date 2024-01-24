package n11;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class n11Login {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchIphone14Pro() throws InterruptedException {
        driver.get("https://www.n11.com/");

        WebElement aranacakUrun = driver.findElement(By.id("searchData"));
        aranacakUrun.sendKeys("Iphone 14 pro", Keys.ENTER);

        Thread.sleep(2000);
        String resultSearch = driver.findElement(By.className("resultText")).getText();
        String expectedResultText = "Iphone 14 Pro için 12,855 sonuç bulundu.";
        assertEquals(expectedResultText, resultSearch);
    }




    @Test

    public void test() throws InterruptedException {
        driver.get("https://www.n11.com/");

        String pageTitle = "n11 - 10 Üzerinden 11'lik Alışveriş Deneyimi";
        String actualPageTitle = driver.getTitle();
        assertEquals(pageTitle, actualPageTitle);

        // Enter a Product
        WebElement aranacakUrun = driver.findElement(By.id("searchData"));
        aranacakUrun.sendKeys("Samsung S23 Ultra", Keys.ENTER);

        String resultSearch = driver.findElement(By.className("resultText")).getText();
        System.out.println("resultSearch = " + resultSearch);

        String expectedResultText = "Samsung S23 Ultra için 3,156 sonuç bulundu.";
        System.out.println("expectedResultText = " + expectedResultText);

        assertEquals(expectedResultText, resultSearch);

        Thread.sleep(2000);
        //driver.navigate().back();
        driver.navigate().forward();

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();

    }
}
