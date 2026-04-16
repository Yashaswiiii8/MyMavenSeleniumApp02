package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();

        // HEADLESS MODE (MANDATORY for Jenkins)
        options.addArguments("--headless=new");

        // REQUIRED for Jenkins/Linux
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // OPTIONAL but improves stability
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        // 1. SauceDemo
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        sleep(3000);

        if (driver.getCurrentUrl().contains("inventory")) {
            System.out.println("SauceDemo Login Successful ✅");
        } else {
            System.out.println("SauceDemo Login Failed ❌");
        }

        // 2. Practice Test Automation
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        sleep(3000);

        if (driver.getCurrentUrl().contains("logged-in-successfully")) {
            System.out.println("PracticeTestAutomation Login Successful ✅");
        } else {
            System.out.println("PracticeTestAutomation Login Failed ❌");
        }

        // 3. Automation Exercise
        driver.get("https://automationexercise.com/login");

        driver.findElement(By.name("email")).sendKeys("yudhveerdirghayu@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Jaihanuman@1");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        sleep(3000);

        if (driver.getPageSource().contains("Logout")) {
            System.out.println("AutomationExercise Login Successful ✅");
        } else {
            System.out.println("AutomationExercise Login Failed ❌");
        }

        driver.quit();
    }

    // Cleaner sleep method
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
