package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    @Test
    public void firstTest() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://teamorg2-dev-ed.lightning.force.com/lightning/o/Contact/list?filterName=Recent");

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));

        username.sendKeys("roger.ruiz@oktana.com.tester");
        password.sendKeys("tester2022");
        loginButton.click();

        Thread.sleep(10000);

        WebElement selectAllContactsCheckbox = driver.findElement(By.xpath("(//span[@class='slds-checkbox--faux'])[1]"));
//         WebElement someoneSpecific = driver.findElement(By.xpath("(//a[text()='Roger Ruiz']/ancestor::tr//td/following-sibling::td[@class='slds-cell-edit cellContainer'])[1]"));
        selectAllContactsCheckbox.click();

        WebElement sendListEmailButton = driver.findElement(By.xpath("//div[contains(text(), 'Send List Email')]"));
        sendListEmailButton.click();

        Thread.sleep(4000);

        WebElement subjectField = driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']"));
        subjectField.sendKeys("Now should work");

        Thread.sleep(5000);

        WebElement emailBodyIframe = driver.findElement(By.xpath("//div[@class='content iframe-parent']//iframe"));
        driver.switchTo().frame(emailBodyIframe);

        Thread.sleep(5000);

        WebElement emailBody = driver.findElement(By.xpath("//div[@id='cke_editor']//iframe"));
        driver.switchTo().frame(emailBody);

        Thread.sleep(1000);

        WebElement emailBodyTextArea = driver.findElement(By.cssSelector("body"));
        emailBodyTextArea.sendKeys("Hi, you received this email as a composite Github Action from one " +
                                           "customer repo triggering the other repo where the action is going to execute " +
                                           "a test that will send an email to the Incubator Team Members every time " +
                                           "the customer repo triggers the event on push to the master(main) branch. " +
                                           "Github customer repo: https://github.com/rogeruiz22/customerRepo-friday27-950.git, " +
                                           "Github target repo: https://github.com/rogeruiz22/odoafRepo-friday27-950.git");

        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        WebElement sendButton = driver.findElement(By.xpath("//button[text()='Send']"));
        sendButton.click();

        Thread.sleep(2000);
        
        String pageTitle = driver.getTitle();
        
//        Assert.assertEquals(pageTitle, "Recently Viewed | Contacts | Salesforce");

//        Assert.assertTrue(true);

        driver.quit();
    }
}
