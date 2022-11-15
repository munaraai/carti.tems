package cart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Items {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\driver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		String username ="standard_user";
		String password ="secret_sauce";
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		//Thread.sleep("3000");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		int expectedITems = 6;

		List <WebElement> myButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < myButtons.size(); i++) {
			myButtons.get(i).click();
		}

		String actualItemsAdded = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		
		int theRealNumber = Integer.parseInt(actualItemsAdded);

		Assert.assertEquals(theRealNumber,expectedITems);
		
	}}

