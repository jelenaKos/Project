package JelenaTesting.Testing;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CreateArticlePage {


	private WebDriver driver;

	public CreateArticlePage(WebDriver driver) {
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

	public WebElement getPlus() {
		return driver.findElement(By.xpath("/html/body/div[1]/header/div[6]/details/summary"));
	}

	public WebElement getNewGist() {
		return driver.findElement(By.xpath("/html/body/div[1]/header/div[6]/details/details-menu/a[3]"));
	}

	public WebElement getAllGists() {
		//	return driver.findElement(By.xpath("//*[@id=\"gist-pjax-container\"]/div[1]/div/div/ul/li[2]/a"));
		//	return driver.findElement(By.xpath("//*[@id='gist-pjax-container']"));
		return driver.findElement(By.xpath("/html/body/div[4]/div/main/div[1]/div/div/ul/li[2]/a"));
	}


	public WebElement getFileName() {
		return driver.findElement(By.xpath("//*[@id=\"gists\"]/div[2]/div/div[1]/div[1]/input[2]"));
	}

	public void setFileName(String fileName) {
		WebElement fileNameInput = getFileName();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileNameInput.click();
		fileNameInput.clear();
		fileNameInput.sendKeys(fileName);

	}

	public WebElement getDescription() {
		return driver.findElement(By.name("gist[description]"));
	}


	public void setDescription(String description) {
		WebElement descriptionInput = getDescription();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		descriptionInput.click();
		descriptionInput.clear();
		descriptionInput.sendKeys(description);
	}
	/*
	public WebElement getFileBody() {
		return driver.findElement(By.xpath("//*[@id=\"gists\"]/div[2]/div/div[2]/div/div[5]/div[1]/div/div/div/div[5]/div/pre"));
	}

	public void setFileBody(String fileBody) {
		WebElement fileBodyInput = getFileBody();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileBodyInput.click();
		fileBodyInput.clear();
		fileBodyInput.sendKeys(fileBody);
	}

	 */

	public WebElement getAddFile() {
		return driver.findElement(By.xpath("//*[@id=\"new_gist\"]/div/button"));
	}


	public WebElement getAddedFile() {
		return driver.findElement(By.id("file-jelena"));
	}


	public void createArticle(String fileName, String description, String fileBody) {

		setFileName(fileName);
		setDescription(description);
		//	setFileBody(fileBody);
		getAddFile().click();
	}
}
