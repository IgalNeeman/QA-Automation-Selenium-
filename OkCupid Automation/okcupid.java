package selenumP;
import java.util.List; //לשים לב לעשות לזה IMPORT ולא למשהו אחר בטעות זה זורק ERR !!!!
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



@SuppressWarnings("unused")
public class first 
	{
	
	public static void main(String[] args) throws InterruptedException 
	{
		List<WebElement> elements;

		int sumgirls = 0, x=0;
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.okcupid.com/login"); //    האתר שלי - פתיחת הדפדפן בחלון קטן עם הכתובת
		driver.manage().window().maximize(); // הגדלת החלון של הדפדפן שיהיה גדול
		WebElement login = driver.findElement(By.className("login-actions-link"));
		 driver.findElement(By.id("onetrust-accept-btn-handler")).click(); 
		 login.click(); 
		 
		 Set<String> handles = driver.getWindowHandles(); 
		    String currentHandle = driver.getWindowHandle();
		    for (String handle : handles) {

		     if (!handle .equals(currentHandle))
		     {
		         driver.switchTo().window(handle);
		     }
		   }
		   //fill your form in the other tab
			 driver.findElement(By.id("email")).sendKeys("falael@013.net.il"); //return void !
			 driver.findElement(By.id("pass")).sendKeys("omg!!p4ss"); //return void !
			 driver.findElement(By.id("loginbutton")).click(); //clicking on button login facebook newtab
		   //go back to first tab if you want
		   driver.switchTo().window(currentHandle);

		   Thread.sleep(6000);
			driver.get("https://www.okcupid.com/who-you-like?cf=likesIncoming"); //    האתר שלי - פתיחת הדפדפן בחלון קטן עם הכתובת
			Thread.sleep(8000);
		   
		int elementsCount= driver.findElements(By.className("userthumb-img")).size();

		System.out.println("Amount of elements: " + elementsCount); //Success

			for (x = 0; x <= elementsCount; x++) 
			{
//		         elements = driver.findElements(By.cssSelector(".usercard-thumb .userthumb img.userthumb-img"));
//		        Thread.sleep(8000);   
//		        WebElement client = elements.get(0);
//		        client.click();
				   Thread.sleep(12000);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //WATING

		         WebElement clickongirl=driver.findElement(By.cssSelector(".usercard-thumb .userthumb img.userthumb-img"));
			        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", clickongirl);
		         
		        Thread.sleep(8000);
//		        driver.findElements(By.cssSelector("button[class='pill-button profile-pill-buttons-button message-pill-button'][id='pass-button']")).get(1).click();
		        WebElement clickonmsg=driver.findElement(By.cssSelector("button[class='pill-button profile-pill-buttons-button message-pill-button'][id='pass-button']"));
		        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", clickonmsg);
		        Thread.sleep(8000);
		        //לאחר על לחיצה על "הודעה" אני רוצה לראות אם יש שגיאה בדף  Nothing to see here 
		        
		        boolean Error = driver.getPageSource().contains("If you think this is an error, "); //Nothing to see here 
		        sumgirls++;
		        if (Error == true)
		        {
		         System.out.print("Nothing to see here\n");
			     Thread.sleep(10000);
			     driver.findElements(By.cssSelector("button[id='pass-button']")).get(2).click(); //PASS THE USER because "Nothing to see here"
			    //מבטל את ההתאמה - כי התיבה שלה מלאה - וזה מפיל את התוכנה
			     x=0;
			     Thread.sleep(3000);
			     driver.get("https://www.okcupid.com/who-you-like?cf=likesIncoming");
		        }
		        else {
			        Thread.sleep(8000);
			        driver.findElement(By.cssSelector(".messenger-composer")).sendKeys("היי אשמח להכיר אותך.");
			        
			        Thread.sleep(5000);
			        WebElement send=driver.findElement(By.cssSelector(".messenger-toolbar-send"));
			        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", send);
//		            driver.findElements(By.cssSelector(".messenger-toolbar-send")).get(0).click();
			        //הישתמשתי בזה בגלל השגיאה שהוא לא מוצא את האלמנט בדף JAVASCRIPT EXCTUOR  הדרייבר לא  לוחץ או נתקע באמצע.
		            Thread.sleep(8000);   
		            driver.get("https://www.okcupid.com/who-you-like?cf=likesIncoming");
		        
		        System.out.println("Girl number: " + x + "\n");

		        if(x==elementsCount-1) {
			        System.out.printf("Time to Sleep... finishe loop again... total girls send msg:"  + sumgirls + "\n" );
			        x=0;
		            Thread.sleep(60000);   

		        }
		        }
		        	
		    }

	}
	
	//driver.close();

	}

