package JelenaTesting.Testing;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
	private WebDriver driver;

	public SignUpPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean isDisplayed( WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public WebElement getUsername() {
		return driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
	}

	public void setUsername(String username) {
		WebElement usernameInput = getUsername();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usernameInput.click();
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}

	public WebElement getEmailAdress() {
		return driver.findElement(By.xpath("//*[@id=\"user_email\"]"));
	}

	public void setEmailAdress(String emailAdress) {
		WebElement emailAdressInput = getEmailAdress();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emailAdressInput.click();
		emailAdressInput.clear();
		emailAdressInput.sendKeys(emailAdress);
	}

	public WebElement getPassword() {
		return driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
	}

	public void setPassword(String password) {
		WebElement passwordInput = getPassword();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		passwordInput.click();
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public WebElement getAllEmails() {
		return driver.findElement(By.id("all_emails"));
	}

	/*
	public WebElement getVerifyBtn(){

		return driver.findElement(By.id("FunCAPTCHA"));
	}

	public WebElement getDoneBtn(){

		return driver.findElement(By.xpath(""));
	}

	public WebElement getCreateAccountBtn(){

		return driver.findElement(By.xpath("//*[@id=\"signup_button\"]"));
	}
	 */
	public void navigateToPage() {
		driver.navigate().to("https://github.com/join?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F%3Cuser-name%3E%2F%3Crepo-name%3E&source=header-repo&source_repo=gothinkster%2Fangular-realworld-example-app");
	}


	public void signUp(String username, String emailAdress, String password) {
		setUsername(username);
		setEmailAdress(emailAdress);
		setPassword(password);
		getAllEmails().click();
		//	getVerifyBtn().click();
		//	getDoneBtn().click();
		//	getCreateAccountBtn().click();

	}

}
