/*
This script is made by Suraj Singh. Please Enter your username and password for testing.
otherwise use my dummy username and password.
Username = "SurajQA"
Password = "Suraj@12345"
 */

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTesting{

    public static void logInFunctionality(String username, String password){

         WebDriverManager.chromedriver().setup();
        //using ChromeDriver 122.0.6261.69.
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\suraj\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/login");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)","");

        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        driver.findElement(By.xpath("//button[@id='login']")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='userName-value']")));

        String currentURL = driver.getCurrentUrl();
        if(currentURL.equals("https://demoqa.com/profile"))
            System.out.println("Login Successfully.");
        else
            System.out.println("Please Rerun the code, there must be some problem in this run.");

    }

    public static void main(String[] args) {

        logInFunctionality("SurajQA","Suraj@12345");
    }
}
