package com.herokuapp.theinternet;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GithubTests {
	
	@Test
	public void githubTest()
	{
		System.out.println("Starting loginTest");

//		Create driver
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// sleep for 3 seconds
		sleep(3000);

		// maximize browser window
		driver.manage().window().maximize();

//		open test page
		String url = "https://github.com/login";
		driver.get(url);
		System.out.println("Page is opened.");

//		enter username
		WebElement username = driver.findElement(By.id("login_field"));
		username.sendKeys("sidharthjaiswal");
		sleep(1000);

//		enter password
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Sidh221101");
		sleep(3000);

//		click login button
		WebElement logInButton = driver.findElement(By.xpath("//input[@name='commit']"));
		logInButton.click();

		sleep(5000);
		
		
//		verificatins:
		String expectedUrl = "https://github.com/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		
		//	 new repo button is visible
		WebElement repoButton = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-primary text-white']"));
		Assert.assertTrue(repoButton.isDisplayed(), "New Repo button is visible");
		repoButton.click();
		
		// sleep for 2 seconds
		sleep(2000);

		driver.quit();
	}
	

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
