package com.cheragh;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String BASE_URL = "https://admin:123qweasd@tmfdev.ir/";
        String first_name = "mohsen";
        String last_name = "ataei asad";
        String mobile_number = "09330192943";
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

        webDriver.get(BASE_URL);
        WebDriverWait wait = new WebDriverWait(webDriver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='ورود یا ثبت نام']")));

        webDriver.findElement(By.xpath("//a[text()='ورود یا ثبت نام']")).click();

        webDriver.findElement(By.id("register_first_name_input")).sendKeys(first_name);
        webDriver.findElement(By.id("register_last_name_input")).sendKeys(last_name);
        webDriver.findElement(By.id("register_mobile_input")).sendKeys(mobile_number);

        webDriver.findElement(By.id("register_submit_button")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
}
