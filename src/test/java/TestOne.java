import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class TestOne {

    protected WebDriver chromedriver;
    @Test
    public void doSeek (){

       /* //Set Firefox Driver
        System.setProperty("webdriver.gecko.driver","/Users/valeacosta/Documents/proyectos/serenity/src/main/resources/geckodriver");

        //Create options over driver
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette",false); */

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);

        //New Web instance
        chromedriver = new ChromeDriver();

        //Waiting time to let time to charge page
        chromedriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Open Google
        chromedriver.get("https://www.google.com");

        //Find an Element and interact with it
        //Enter text
        chromedriver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Where is colombia");
        //Press Enter
        chromedriver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(Keys.ENTER);
        //Click link
        chromedriver.findElement(By.xpath("//h3[contains(text(),'National Geographic Kid')]")).click();
        //Create a web element to do actions
        WebElement text = chromedriver.findElement(By.xpath("//p[@class='Article__Headline__Desc']"));
        //Validate text
        Assert.assertTrue(text.getText().contains("South America"));
        //Close window, down driver
        chromedriver.quit();
    }
}
