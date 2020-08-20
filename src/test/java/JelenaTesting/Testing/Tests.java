package JelenaTesting.Testing;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


@Test
public class Tests {

	private WebDriver driver;
	private SignInPage signInPage;
	private MenuPage menuPage;
	private String baseUrl;
	private SignUpPage signUpPage;
	private CreateArticlePage createArticlePage;
	private PostCommentPage postCommentPage;


	@BeforeSuite 
	public void setupSelenium() {
		baseUrl = "https://github.com/gothinkster/angular-realworld-example-app";
		System.setProperty("webdriver.gecko.driver","D:/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1024, 768));
		driver.navigate().to(baseUrl);
		setupPages();
	}

	@BeforeTest
	public void setupPages() {

		signInPage = new SignInPage(driver);
		menuPage = new MenuPage(driver);
		signUpPage = new SignUpPage(driver);
		createArticlePage= new CreateArticlePage (driver);
		postCommentPage= new PostCommentPage (driver);
	}

	public boolean isDisplayed(By by) { //help method 1
		// TODO Auto-generated method stub
		return false;
	}

	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {  //help method 3
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}

	@Test (priority=1)
	public void signUp(){
		menuPage.getSignUpBtn().click();
		assertTrue(signUpPage.getUsername().isDisplayed());
		assertTrue(signUpPage.getEmailAdress().isDisplayed());
		assertTrue(signUpPage.getPassword().isDisplayed());
		assertTrue(signUpPage.getAllEmails().isDisplayed());
		signUpPage.signUp("JelenaKosturanova", "jelena.kosturanova1@gmail.com", "Milavanja2010");
		//verification btn 

	}

	@Test (priority=2)
	public void signInWrongCredentials() {
		menuPage.getSignInBtn().click();
		assertTrue(signInPage.getUsername1().isDisplayed());
		assertTrue(signInPage.getPassword1().isDisplayed());
		signInPage.signIn("jelenaKost", "11111");
		assertTrue(signInPage.getWrongCredentialsMessage().isDisplayed());
	}

	@Test (priority=3)
	public void signIn() {
		assertTrue(signInPage.getUsername1().isDisplayed());
		assertTrue(signInPage.getPassword1().isDisplayed());
		signInPage.signIn("jelenaKos", "milavanja2010");
		assertTrue(menuPage.getImage().isDisplayed());
	}

	@Test (priority=4)
	public void createArticle() {
		assertTrue(createArticlePage.getPlus().isDisplayed());

		createArticlePage.getPlus().click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		createArticlePage.getNewGist().click();
		assertTrue(createArticlePage.getFileName().isDisplayed());
		assertTrue(createArticlePage.getDescription().isDisplayed());
		assertTrue(createArticlePage.getAllGists().isDisplayed());
		createArticlePage.createArticle("Jelena", "Jelena Kosturanova", "JK");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createArticlePage.getAllGists().click();
		assertTrue(createArticlePage.getAddedFile().isDisplayed());

	}

	@Test (priority=5)
	public void postComment() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		postCommentPage.getComments().click();
		postCommentPage.postComment("Success");
		assertTrue(postCommentPage.getCommentConfirmation().isDisplayed());
	} 


	@AfterSuite
	public void closeSelenium() {
		driver.quit();
	}
}