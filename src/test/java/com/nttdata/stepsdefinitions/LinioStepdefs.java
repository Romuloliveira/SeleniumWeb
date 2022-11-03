package com.nttdata.stepsdefinitions;


import com.nttdata.page.LinioLoginPage;
import com.nttdata.steps.LinioLoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.junit.jupiter.api.Assertions;

public class LinioStepdefs {

        private WebDriver driver;
        private Scenario scenario;

        private LinioLoginSteps linio = new LinioLoginSteps(driver);


        @Before(order = 0)
        public void setUp(){
            //setUp
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            //crear el driver
            driver = new ChromeDriver();
            //max
            driver.manage().window().maximize();

        }

        @Before(order = 1)
        public void setScenario(Scenario scenario){
            this.scenario = scenario;
        }

        @After
        public void quitDriver(){
            driver.quit();
        }

        @Given("the url {string}")
        public void theUrl(String url) {
            driver.get(url);
            screenShot();
        }

        @When("fill the email input with the email {string}")
        public void fillTheEmailInputWithTheEmail(String email) {

            linio.type_email(email);
            screenShot();
        }

        @And("fill the password input with the password {string}")

        public void fillThePasswordInputWithThePassword(String password) {
            linio.type_password(password);
            screenShot();
        }

        @And("click the login button")
        public void clickTheLoginButton() {
            linio.click_login();
            screenShot();
        }

        @Then("the login must be successful, header profile username must be {string}")
        public void theLoginMustBeSuccessful(String name) {
            String text = this.driver.findElement(LinioLoginPage.linio_profile_name).getText();
            Assertions.assertEquals(name, text);
        }

        @And("click in the compra y recibe hoy button")
        public void clickInTheCompraYRecibeHoyButton() {
            linio.click_recibehoy_button();
        }

        @And("Add product to the cart")
        public void addProductToTheCart() {
            linio.add_product_to_cart();
            screenShot();
        }

        @Then("Check message {string} if the product was added to the cart")
        public void checkIfTheProductWasAdded(String ExpectedMessage) {
            String message = this.driver.findElement(LinioLoginPage.linio_add_to_cart_msg).getText();
            Assertions.assertEquals(ExpectedMessage, message);
        }


        public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
        }



}

