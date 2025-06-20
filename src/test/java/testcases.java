import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTests {

    @Test
    public void testSuccessfulLogin() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            
            Assert.assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testLoginWithInvalidPassword() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("wrong_password");
            driver.findElement(By.id("login-button")).click();
            
            WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
            Assert.assertTrue(errorMessage.isDisplayed());
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testAddProductToCart() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            
            driver.findElement(By.cssSelector(".inventory_item:nth-child(1) .btn_inventory")).click();
            WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
            Assert.assertEquals("1", cartBadge.getText());
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCompleteOrderProcess() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            
            driver.findElement(By.cssSelector(".inventory_item:nth-child(1) .btn_inventory")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            driver.findElement(By.id("checkout")).click();
            
            driver.findElement(By.id("first-name")).sendKeys("John");
            driver.findElement(By.id("last-name")).sendKeys("Doe");
            driver.findElement(By.id("postal-code")).sendKeys("12345");
            driver.findElement(By.id("continue")).click();
            
            driver.findElement(By.id("finish")).click();
            WebElement orderConfirmation = driver.findElement(By.className("complete-header"));
            Assert.assertTrue(orderConfirmation.isDisplayed());
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testLogout() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.saucedemo.com");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            
            driver.findElement(By.id("react-burger-menu-btn")).click();
            driver.findElement(By.id("logout_sidebar_link")).click();
            
            WebElement loginButton = driver.findElement(By.id("login-button"));
            Assert.assertTrue(loginButton.isDisplayed());
        } finally {
            driver.quit();
        }
    }
}
