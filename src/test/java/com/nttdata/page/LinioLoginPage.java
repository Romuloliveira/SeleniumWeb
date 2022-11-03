package com.nttdata.page;

import org.openqa.selenium.By;

public class LinioLoginPage {

    //Localizadores de elementos
    public static By linio_email = By.id("login_form_email");

    public static By linio_password = By.id("login_form_password");

    public static By linio_submit_button = By.xpath("//*[@id=\"login-form\"]/form/button");


    public static By linio_profile_name = By.id("header-profile-user-name");

    public static By linio_comprayrecibehoy = By.xpath("/html/body/div[4]/main/div[1]/div[1]/div[1]/a[1]");

    public static By linio_first_product = By.xpath("//*[@id=\"feed-manual-1\"]/div/div[1]/a[1]");

    public static By linio_buy_button = By.id("buy-now");

    public static By linio_add_to_cart_msg = By.xpath("//*[@id=\"alert-add-to-cart\"]/div/div/div[1]/div/h2[1]");
}
