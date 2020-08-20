package JelenaTesting.Testing;


import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MenuPage {

	private WebDriver driver;

	public MenuPage(WebDriver driver) {
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

	public WebElement getSignUpBtn() {
		return driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[2]"));

	}

	public WebElement getSignInBtn() {
		return driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]"));

	}

	public WebElement getImage() {
		return driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary/img"));

	}

	public WebElement getSignOutBtn() {
		return driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/form/button"));

	}


}
