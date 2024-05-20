
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Main {

    public static void main(String [] args){
        System.out.println("Start");
        formTest();
        System.out.println("End");
    }

    public static void formTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        System.out.println("Test: "+ title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        System.out.println("Web Response: "+ value);
        System.out.print("Test Result: ");
        if(value.equals("Received!") == true){
            System.out.println("Pass");
        }else{
            System.out.println("Error");
        }

        driver.quit();
    }

}