package JelenaTesting.Testing;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SignInPage {

	private WebDriver driver;

	public SignInPage (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayed( WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public WebElement getUsername1() {
		return driver.findElement(By.id("login_field"));
	}

	public void setUsername1(String username1) {
		WebElement username1Input = getUsername1();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		username1Input.click();
		username1Input.clear();
		username1Input.sendKeys(username1);
	}

	public WebElement getPassword1() {
		return driver.findElement(By.xpath("//*[@id=\"password\"]"));
	}

	public void setPassword1(String password1) {
		WebElement password1Input = getPassword1();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password1Input.click();
		password1Input.clear();
		password1Input.sendKeys(password1);
	}

	public WebElement getSignInBtn(){

		return driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/input[9]"));
	}

	public WebElement getWrongCredentialsMessage(){

		return driver.findElement(By.xpath("/html/body/div[3]/main/div/form/div[2]/div/div"));
	}

	public void navigateToPage() {
		driver.navigate().to("https://github.com/login");
	}

	public void signIn(String username1, String password1) {
		setUsername1(username1);
		setPassword1(password1);
		getSignInBtn().click();
	}
}
