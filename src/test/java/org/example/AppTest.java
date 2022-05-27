package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest {
    @Test
    public void firstTest() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://teamorg2-dev-ed.lightning.force.com/lightning/o/Contact/list?filterName=Recent");

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));

        username.sendKeys("incubatorteam@oktana.com");
        password.sendKeys("incubator2022");
        loginButton.click();

        Thread.sleep(8000);

//        WebElement selectAllContactsCheckbox = driver.findElement(By.xpath("(//span[@class='slds-checkbox--faux'])[1]"));
        WebElement selectRogerContact = driver.findElement(By.xpath("(//a[text()='Roger Ruiz']/ancestor::tr//td/following-sibling::td[@class='slds-cell-edit cellContainer'])[1]"));
        selectRogerContact.click();

        WebElement sendListEmailButton = driver.findElement(By.xpath("//div[contains(text(), 'Send List Email')]"));
        sendListEmailButton.click();

        Thread.sleep(4000);

        WebElement subjectField = driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']"));
        subjectField.sendKeys("Incubator Team - Github Actions funciona !!! :)");

        Thread.sleep(3000);

        WebElement emailBodyIframe = driver.findElement(By.xpath("//div[@class='content iframe-parent']//iframe"));
        driver.switchTo().frame(emailBodyIframe);

        Thread.sleep(2000);

        WebElement emailBody = driver.findElement(By.xpath("//div[@id='cke_editor']//iframe"));
        driver.switchTo().frame(emailBody);

        Thread.sleep(1000);

        WebElement emailBodyTextArea = driver.findElement(By.cssSelector("body"));
        emailBodyTextArea.sendKeys("Este email fue enviado automaticamente usando workflows en " +
                                           "Github Actions con Selenium test. Se ejecuto y se ejecutara al hacerle push a la rama principal. " +
                                           "Github Repo: https://github.com/rogeruiz22/martes171119.git");

        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        WebElement sendButton = driver.findElement(By.xpath("//button[text()='Send']"));
        sendButton.click();

        Thread.sleep(2000);

        driver.quit();
    }
}