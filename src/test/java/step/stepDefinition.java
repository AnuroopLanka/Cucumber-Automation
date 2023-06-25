package step;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepDefinition extends Screenshot {
	public static WebDriver driver;

	@Given("user is on {string} website")
	public void user_is_on_cleartrip_website(String url) {
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("User is on cleartrip home page");
	}

	@When("user enter details departure {string} and arrival {string} and clicks on search button")
	public void user_enter_details_deparure_and_arrival_and_clicks_on_search_button(String dep,String arr) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement crxbtn = driver.findElement(By.xpath("//*[@class=' c-pointer c-neutral-900']"));
		crxbtn.click();
		WebElement button = driver.findElement(By.xpath("//span[text()='1 Adult, Economy']"));
		button.click();
		List<WebElement> adchbtn = driver.findElements(By.xpath("//*[@class='current-stroke c-blue c-pointer'][1]"));
		WebElement x=adchbtn.get(0);
		x.click();
		WebElement y=adchbtn.get(1);
		y.click();
		Thread.sleep(2000);
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='Where from?']"));
		from.sendKeys(dep);
		WebElement delhi = driver.findElement(By.xpath("//p[text()='New Delhi, IN - Indira Gandhi Airport (DEL)']"));
		delhi.click();
		Thread.sleep(5000);
		WebElement to = driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
		to.sendKeys(arr);
		WebElement chn = driver.findElement(By.xpath("//p[text()='Chennai, IN - Chennai Airport (MAA)']"));
		chn.click();
		WebElement depdatebtn = driver
				.findElement(By.xpath("//div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/button[1]"));
		depdatebtn.sendKeys(Keys.ENTER);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("scroll(0, 250)"); // if the element is on bottom
		Thread.sleep(2000);
		WebElement depdate = driver.findElement(By.xpath("//div[text()='31']"));
		depdate.click();
		System.out.println("done till here");
		WebElement searchbtn = driver.findElement(By.xpath("//span[text()='Search flights']"));
		searchbtn.click();		
	}

	@Then("goes to next page to view search results")
	public void goes_to_next_page_to_view_search_results() {
		System.out.println("User entered details and clicked on search button successfully");

	}

	@Given("user is on search results page")
	public void user_is_on_search_results_page() {
		System.out.println("User is on Search results page");
	}

	@When("user clicks on book button")
	public void user_clicks_on_book_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement bookbtn = driver.findElement(By.xpath("//button[text()='Book']"));
		bookbtn.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Then("navigates to next page to view flight details")
	public void navigates_to_next_page_to_view_flight_details() {
		System.out.println("User clicked on book successfully");
		
	}

	@Given("user is on flight iternary page")
	public void user_is_on_flight_iternary_page() throws InterruptedException {
		

		System.out.println("User naviagtes to flight itenary details page");
	}

	@When("user captures flight details")
	public void user_captures_flight_details() throws IOException {
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles()); 
		if (!availableWindows.isEmpty()) { 
		driver.switchTo().window(availableWindows.get(1)); 
		}
		System.out.println("-------------Journey details-----------");
		WebElement city=driver.findElement(By.xpath("//div[@class='flex flex-between flex-bottom']"));
		 {
			String y=city.getText();
			System.out.println(y);
		
		}
		stepDefinition.takeScreenshot(driver," details");
		WebElement dep=driver.findElement(By.xpath("//div[@class='flex'][1]"));
		
		String z=dep.getText();
		System.out.println("------------Depature details------------");
		System.out.println(z);
		WebElement arr=driver.findElement(By.xpath("//div[@class='flex flex-bottom flex-1'][1]"));
		String a=arr.getText();
		System.out.println("------------Arrival details------------");
		System.out.println("Arrival details: "+a);
		WebElement tt=driver.findElement(By.xpath("//div[@class=' flex mr-10']"));
		String tot=tt.getText();
		System.out.println("Total Time: "+tot);
		WebElement tp=driver.findElement(By.xpath("//div[@class='flex flex-middle flex-between']"));
		String totp=tp.getText();
		System.out.println(totp);
		

	}

	@Then("prints and quits")
	public void prints_and_quits() {
		driver.quit();
	}

}
