package com.seleniummaster.classtutorial.cubecarttest;

public class CubeCartTestRunner {
    public static void main(String[] args) {
        LoginUser loginUser = new LoginUser("testautomation","automation123!");
        FunctionLibrary functionLibrary = new FunctionLibrary();
        functionLibrary.openBrowser("http://cubecart.unitedcoderschool.com/ecommerce/admin_w4vqap.php");
        functionLibrary.login(loginUser);
        String timestamp = String.valueOf(System.currentTimeMillis());
        Product product = new Product(true,"Uyghur Nan" + timestamp,"New","Nan" + timestamp);
        functionLibrary.addProduct(product);
        Customer customer = new Customer(true,"Java Automation" + timestamp,"kurshad","bughra","kurshadbughra@gmail.com");
        functionLibrary.addCustomer(customer);
        functionLibrary.logout();
        functionLibrary.closeBrowser();
    }
}
