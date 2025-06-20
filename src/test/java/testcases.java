public class LoginTest {
    @Test
    public void loginWithValidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        // Ellenőrizze, hogy a bejelentkezés sikeres volt
        Assert.assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
        
        driver.quit();
    }
}
