package assignment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tatoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exepath="/home/qainfotech/Downloads/chromedriver";
		System.setProperty("webdriver.chrome.driver",exepath);
		WebDriver driver=new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.cssSelector("a")).click();
		driver.findElement(By.className("greenbox")).click();
		
		driver.switchTo().frame(0);
		String box1Color=driver.findElement(By.id("answer")).getAttribute("class");

		List<WebElement> results = driver.findElements(By.cssSelector("a"));
		
		Boolean condition=true;

		
		while(condition) {
			
			results.get(0).click();
			driver.switchTo().frame("child");
			String box2Color=driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			
			if(box1Color.equals(box2Color)) {
				results.get(1).click();
				condition=false;
			}}
	         driver.switchTo().defaultContent();
	         
			WebElement drop = driver.findElement(By.id("dropbox"));
	        WebElement drag = driver.findElement(By.id("dragbox"));
	        Actions act=new Actions(driver);
	        act.dragAndDrop(drag, drop).build().perform();
	        driver.findElement(By.linkText("Proceed")).click();
	        
			driver.findElement(By.cssSelector("a")).click();
	        List windowsList=new ArrayList(driver.getWindowHandles());
	        String windows1= ((String)windowsList.get(1));
	        driver.switchTo().window(windows1);
	        driver.findElement(By.id("name")).sendKeys("Barkha");
	        driver.findElement(By.id("submit")).click();
	        String windows2=(String)(windowsList.get(0));
	        driver.switchTo().window(windows2);
	        driver.findElement(By.linkText("Proceed")).click(); 
	        
	        driver.findElement(By.linkText("Generate Token")).click(); 
	          String Token = driver.findElement(By.id("token")).getText();
	          String substring1=Token.substring(7);
	          Cookie name = new Cookie("Token", substring1);
	  		  driver.manage().addCookie(name);
	  		  
	  		driver.findElement(By.linkText("Proceed")).click(); 
	          
		
		
	}

}
