package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class GridTest {
	@Test
	public void test1() throws MalformedURLException {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		// System.setProperty("webdriver.chrome.driver", "chromedriver");
		System.setProperty("webdriver.gecko.driver", "geckodriver");

		// WebDriver driver = new ChromeDriver();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setPlatform(Platform.LINUX);
		caps.setBrowserName("chrome");

		URL url = new URL(" http://localhost:4444/wd/hub");
		WebDriver driver = new RemoteWebDriver(url, caps);

		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(LoginLink));

		LoginLink.click();

		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abc@12345");

		WebElement Remember = driver.findElement(By.className("rememberMe"));
		Remember.click();

		WebElement LoginButton = driver.findElement(By.name("btn_login"));
		LoginButton.click();

		WebElement Error = driver.findElement(By.id("msg_box"));

		String ActualMsg = Error.getText();
		String ExpMsg = "The email or password you have entered is invalid.";

		AssertJUnit.assertEquals(ActualMsg, ExpMsg);

		driver.quit();
	}

	@Test
	public void test2() throws MalformedURLException {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		// System.setProperty("webdriver.chrome.driver", "chromedriver");
		System.setProperty("webdriver.gecko.driver", "geckodriver");

		// WebDriver driver = new ChromeDriver();

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setPlatform(Platform.LINUX);
		caps.setBrowserName("firefox");

		URL url = new URL(" http://localhost:4444/wd/hub");
		WebDriver driver = new RemoteWebDriver(url, caps);

		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(LoginLink));

		LoginLink.click();

		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abc@12345");

		WebElement Remember = driver.findElement(By.className("rememberMe"));
		Remember.click();

		WebElement LoginButton = driver.findElement(By.name("btn_login"));
		LoginButton.click();

		WebElement Error = driver.findElement(By.id("msg_box"));

		String ActualMsg = Error.getText();
		String ExpMsg = "The email or password you have entered is invalid.";

		AssertJUnit.assertEquals(ActualMsg, ExpMsg);

		driver.quit();
	}

}