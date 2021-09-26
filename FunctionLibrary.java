package com.seleniummaster.classtutorial.cubecarttest;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionLibrary {
    WebDriver driver;

    public void openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public boolean login(LoginUser loginUser) {
        WebElement userNameElement = driver.findElement(By.id("username"));
        waitUntilElementIsVisible(userNameElement);
        userNameElement.sendKeys(loginUser.getUserName());

        WebElement passwordElement = driver.findElement(By.id("password"));
        waitUntilElementIsVisible(passwordElement);
        passwordElement.sendKeys(loginUser.getPassword());

        WebElement loginButton = driver.findElement(By.id("login"));
        waitUntilElementIsVisible(loginButton);
        loginButton.click();

        WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        waitUntilElementIsVisible(logoutIcon);
        if (logoutIcon.isDisplayed()) {
            System.out.println("User logged successfully");
            return true;
        } else {
            System.out.println("User login failed");
            return false;
        }
    }

    public boolean addProduct(Product product) {
        WebElement productLink = driver.findElement(By.id("nav_products"));
        waitUntilElementIsVisible(productLink);
        productLink.click();

        WebElement addProductLink = driver.findElement(By.linkText("Add Product"));
        waitUntilElementIsVisible(addProductLink);
        addProductLink.click();

        WebElement productNameElement = driver.findElement(By.id("name"));
        waitUntilElementIsVisible(productNameElement);
        productNameElement.sendKeys(product.getName());

        WebElement productConditionElement = driver.findElement(By.id("condition"));
        waitUntilElementIsVisible(productConditionElement);
        Select selectCondition = new Select(productConditionElement);
        selectCondition.selectByVisibleText(product.getCondition());

        WebElement productCodeElement = driver.findElement(By.id("product_code"));
        waitUntilElementIsVisible(productCodeElement);
        productCodeElement.sendKeys(product.getCode());

        WebElement saveButton = driver.findElement(By.cssSelector("input[value='Save']"));
        waitUntilElementIsVisible(saveButton);
        saveButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("div.success"));
        waitUntilElementIsVisible(successMessage);
        if (successMessage.isDisplayed()) {
            System.out.println("add Product Successfully");
            System.out.println(product.toString());
            return true;
        } else {
            System.out.println("add Product failed");
            return false;
        }
    }

    public boolean addCustomer(Customer customer){
        WebElement customerListLink = driver.findElement(By.xpath("//*[@id=\"menu_Customers\"]/li[1]/a"));
        waitUntilElementIsVisible(customerListLink);
        customerListLink.click();

        WebElement addCustomerLink = driver.findElement(By.linkText("Add Customer"));
        waitUntilElementIsVisible(addCustomerLink);
        addCustomerLink.click();

        WebElement statusLink = driver.findElement(By.xpath("//*[@id=\"general\"]/fieldset[1]/div[1]/span/img"));
        waitUntilElementIsVisible(statusLink);
        statusLink.click();

        WebElement titleElement = driver.findElement(By.id("cust-title"));
        waitUntilElementIsVisible(titleElement);
        titleElement.sendKeys(customer.getTitle());

        WebElement firstNameElement = driver.findElement(By.id("cust-firstname"));
        waitUntilElementIsVisible(firstNameElement);
        firstNameElement.sendKeys(customer.getFirstName());

        WebElement lastNameElement = driver.findElement(By.id("cust-lastname"));
        waitUntilElementIsVisible(lastNameElement);
        lastNameElement.sendKeys(customer.getLastName());

        WebElement emailElement = driver.findElement(By.id("cust-email"));
        waitUntilElementIsVisible(emailElement);
        emailElement.sendKeys(customer.getEmail());

        WebElement saveButton = driver.findElement(By.name("save"));
        waitUntilElementIsVisible(saveButton);
        saveButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("div.success"));
        waitUntilElementIsVisible(successMessage);
        if (successMessage.isDisplayed()){
            System.out.println("add Customer successfully");
            System.out.println(customer.toString());
            return true;
        }else {
            System.out.println("add Customer failed");
            return false;
        }

    }

    public void logout(){
        WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        waitUntilElementIsVisible(logoutIcon);
        logoutIcon.click();
    }

    public void closeBrowser(){
        driver.close();
        driver.quit();
    }

    public void waitUntilElementIsVisible(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
