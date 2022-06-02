package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AnotherTest {
    @Test
    public void secondTest() throws Exception {
        WebDriver driver = new ChromeDriver();

//        driver.manage().window().maximize();

        driver.get("https://www.gmail.com");

        WebElement emailField = driver.findElement(By.xpath("//input[@id='identifierId']"));
        WebElement nextButton = driver.findElement(By.xpath("//span[text()='Siguiente' or text()='Next']"));

        emailField.sendKeys("incubatorteam2022@gmail.com");
        nextButton.click();

        Thread.sleep(5000);

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement nextButton2 = driver.findElement(By.xpath("//span[text()='Siguiente' or text()='Next']"));

        passwordField.sendKeys("incubator2022");
        nextButton2.click();

        Thread.sleep(30000);

        WebElement composeButton = driver.findElement(By.xpath("//div[text()='Redactar' or text()='Compose']"));
        composeButton.click();

        Thread.sleep(2000);

        WebElement toWhoField = driver.findElement(By.xpath("//table[@class='aoP aoC']//div[@role='listbox']//input"));
        toWhoField.sendKeys("cristopher.cardenas@oktana.com, david.heredia@oktana.com, joshua.williams@oktana.com, roger.ruiz@oktana.com, sebastian.vera@oktana.com");

        WebElement subjectField = driver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectField.sendKeys("New Test triggered for the Github Composite Action Test");

        WebElement emailBody = driver.findElement(By.xpath("//div[@aria-label='Message Body' or @aria-label='Cuerpo del mensaje']"));

        emailBody.sendKeys("Hi, you received this email as a composite Github Action from one customer repo " +
                                   "triggering the other repo where the action is going to execute a test that will send " +
                                   "an email to the Incubator Team Members every time the customer repo triggers the " +
                                   "event on push to the master(main) branch. Github customer " +
                                   "repo: https://github.com/rogeruiz22/customerRepo-friday27-950.git, " +
                                   "Github target repo: https://github.com/rogeruiz22/odoafRepo-friday27-950.git");

        WebElement sendButton = driver.findElement(By.xpath("//div[text()='Enviar' or text()='Send']"));
        sendButton.click();

        Thread.sleep(10000);

        driver.quit();

    }
}
