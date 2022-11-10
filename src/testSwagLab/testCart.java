package testSwagLab;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class testCart {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp-laptop\\Desktop\\myNewDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String user_name="standard_user";
		String password="secret_sauce";
		
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(user_name);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(password);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]")).click();
		
		
		Thread.sleep(2000);
		
		
		int expectedNoITems = 6;

		List<WebElement> myButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < myButtons.size(); i++) {
			myButtons.get(i).click();
			
		}
		System.out.println(myButtons.size());
		String actualItemsAdded = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		
		int theRealNumber = Integer.parseInt(actualItemsAdded);

		Assert.assertEquals(theRealNumber, expectedNoITems);
		
		
			
				
			
				
			
		
		
		

	}

}
