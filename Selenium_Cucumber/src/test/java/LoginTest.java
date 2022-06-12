import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class LoginTest {
    ChromeDriver driver;
    ChromeOptions options = new ChromeOptions();

    @Given("browser opened")
    public void browser_opened() {
        System.out.println("Inside step - Buka Browser");
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(getClass().getClassLoader()
                                .getResource("chromedriver_win32/chromedriver.exe")).getFile());
//        throw new io.cucumber.java.PendingException();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @Given("user in register page")
    public void user_in_register_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://demo.guru99.com/insurance/v1/register.php");
        driver.findElement(By.xpath("/html/body/div[3]/a")).click();
    }

    @Given("user in login page")
    public void user_in_login_page() {
//        System.out.println("Inside Step - user ada di halaman login");
//        driver.navigate().to("https://demo.guru99.com/insurance/v1/index.php");
    }

    @When("^user insert (.*) and (.*)$")
    public void user_insert_username_and_password(String password, String email) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("Inside Step - Ada di fungsi user memasukkan username dan password");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        Assertions.assertTrue(email != "" && password.length() >= 8 && password.length() <= 13 && password.matches("^[a-zA-Z0-9]*$")
        );
//
    }
    @When("login button clicked")
    public void login_button_clicked() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("Inside Step - ada di fungsi klik tombol Login");
        driver.findElement(By.name("submit")).click();
    }
    @Then("user redirect to main screen")
    public void user_redirect_to_main_screen() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        System.out.println("Inside Step - ada di halaman user diarahkan ke halaman utama");
        List<WebElement> list = driver.findElements(By.xpath("/html/body/div[3]/form/input"));
        Assertions.assertTrue(list.size()>0,"Text not found");
        driver.close();
        driver.quit();
    }
}
