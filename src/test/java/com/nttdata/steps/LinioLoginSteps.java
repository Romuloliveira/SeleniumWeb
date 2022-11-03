package com.nttdata.steps;

import com.nttdata.page.LinioLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinioLoginSteps {

    private WebDriver driver;

    //constructor
    public LinioLoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void type_email(String email){
        System.out.println("email: " + email);

        WebElement userInputElement = driver.findElement(LinioLoginPage.linio_email);
        userInputElement.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LinioLoginPage.linio_submit_button));

    }


    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void type_password(String password){
        this.driver.findElement(LinioLoginPage.linio_password).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void click_login(){
        this.driver.findElement(LinioLoginPage.linio_submit_button).click();
    }

    public void click_recibehoy_button(){
        this.driver.findElement(LinioLoginPage.linio_comprayrecibehoy).click();
    }

    public void add_product_to_cart(){
        this.driver.findElement(LinioLoginPage.linio_first_product).click();
        this.driver.findElement(LinioLoginPage.linio_buy_button).click();
    }




}
