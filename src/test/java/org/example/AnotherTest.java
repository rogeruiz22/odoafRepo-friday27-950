package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AnotherTest {
    @Test
    public void secondTest() {
        WebDriver driver = new ChromeDriver();

//        driver.manage().window().maximize();

        driver.get("https://accounts.google.com");
    }
}
