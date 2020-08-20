package JelenaTesting.Testing;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PostCommentPage {
	private WebDriver driver;

	public PostCommentPage(WebDriver driver) {
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

	public WebElement getAddedArticle() {

		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		WebElement getAddedArticle = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"file-jelena\"]")));
		getAddedArticle.click();
		return getAddedArticle;

	}


	public WebElement getComments() {
		return driver.findElement(By.xpath("/html/body/div[4]/div/main/div/div/div[2]/div[2]/div[1]/ul/li[3]/a"));
	}


	public WebElement getLeaveCommentField() {
		return driver.findElement(By.id("new_comment_field"));
	}


	public void setLeaveCommentField(String leaveCommentField) {
		WebElement leaveCommentFieldInput = getLeaveCommentField();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		leaveCommentFieldInput.click();
		leaveCommentFieldInput.clear();
		leaveCommentFieldInput.sendKeys(leaveCommentField);
	}

	public WebElement getCommentBtn() {
		return driver.findElement(By.xpath("/html/body/div[4]/div/main/div[2]/div/div/div[3]/div/div[2]/div/form/div/div/div/button"));
	}

	public WebElement getCommentConfirmation() {
		return driver.findElement(By.xpath("/html/body/div[4]/div/main/div[2]/div/div/div[3]/div/div[1]/div[4]/div[2]/div[2]/div[1]/h3"));
	}

	public void postComment(String leaveCommentField) {

		//	getAddedArticle().click();
		setLeaveCommentField(leaveCommentField);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getCommentBtn().click();
	}
}

