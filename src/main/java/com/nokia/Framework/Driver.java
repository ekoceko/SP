package com.nokia.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class Driver {

    public static WebDriver Instance = null;
    public static String SPURL = "http://135.121.41.176:8081/sp/ui/";
    static String SPUN ="webadmin";
    static String SPP = "5620Sam!";

    private Driver(){
        if (Instance !=null){
            throw new RuntimeException("Use Initialize() first to create a Driver Instance");
        }
    }
    public static void Initialize(){
        if (Instance ==null){
            synchronized (Driver.class){
                if (Instance ==null) {
                    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
                    Instance = new FirefoxDriver();
                }
            }
        }
    }
    public static void Quit(){
        Instance.quit();
    }


    public static WebElement fwait(By by){
    Wait<WebDriver> wait = new FluentWait<>(Instance)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));

        return wait.until(Driver -> Driver.findElement(by));}
}
