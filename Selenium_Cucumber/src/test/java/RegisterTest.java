import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisterTest {
    ChromeDriver driver;
    ChromeOptions options = new ChromeOptions();

    @Given("buka browser")
    public void buka_browser() {
        // Write code here that turns the phrase above into concrete actions
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
    @Given("user berada di halaman register")
    public void user_berada_di_halaman_register() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - user ada di halaman register");
        driver.navigate().to("https://demo.guru99.com/insurance/v1/register.php");
        List<WebElement> tombol= driver.findElements(By.tagName("input"));
        List tombol1 = new ArrayList();
        for(WebElement el: tombol){
            if(el.getAttribute("value").equals("Reset")){
                tombol1.add(el.getText());
            }
            if(el.getAttribute("value").equals("Create")){
                tombol1.add(el.getText());
            }
        }
        Assertions.assertTrue(tombol1.size()>1,"Button create atau reset tidak ada");


    }
    @When("^user memasukkan (.*) dan (.*)$")
    public void user_memasukkan_email_dan_password(String email, String password) {
        System.out.println("Inside Step - Ada di fungsi user memasukkan username dan password");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("c_password")).sendKeys(password);
        Assertions.assertTrue(email != "" && password.length() >= 8 && password.length() <= 13 && password.matches("^[a-zA-Z0-9]*$")
                );
    }
    @When("klik tombol register")
    public void klik_tombol_register() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Inside Step - ada di fungsi klik tombol Login");
        driver.findElement(By.xpath("//*[@id=\"new_user\"]/div[5]/input[2]")).click();
    }
    @Then("user mengarahkan ke halamn utama")
    public void user_mengarahkan_ke_halamn_utama() {
        // Write code here that turns the phrase above into concrete actions
//        System.out.println("Inside Step - ada di halaman user diarahkan ke halaman utama");
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"login-form\"]/div[3]/input"));
        Assertions.assertNotNull(list.size()>0, "Text not found");

        driver.close();
        driver.quit();

    }
}
