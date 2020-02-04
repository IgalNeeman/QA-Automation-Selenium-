package selenumP;
import java.util.List; //לשים לב לעשות לזה IMPORT ולא למשהו אחר בטעות זה זורק ERR !!!!
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//טרם כתבתי תוכנית, צריך להתקין את ה- JARS + Libs של ה- Driver (selenium-server-3.9.1)
//ייבוא של קובץ VIDEO.JAR  ןושימוש בפונקצייה הסרטה ScreenRecorder.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class first 
	{

	public static void main(String[] args) throws Exception 
	{

		System.setProperty("webdriver.chrome.driver", "C:/Selenium/driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		ScreenRecorderUtil.startRecord("Check"); // הפעלת הוידאו
		
		driver.get("http://www.getstudy.co.il"); //    האתר שלי - פתיחת הדפדפן בחלון קטן עם הכתובת
		driver.manage().window().maximize(); // הגדלת החלון של הדפדפן שיהיה גדול
		String title = driver.getTitle(); // שמירת הtitle בתוך משתנה 
		System.out.println("page title is: " + title ); //הדפסה של הטייטל לקונסול
		
		 driver.findElement(By.className("hustle-icon-close")).click(); //סגירת הבאנר הראשון שקובץ
		
		//אני רוצה שהאוטומציה תמתין קצת ולכן
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //WATING
		
		if(title.contains("לימודים")) //בדיקה אם הכותרת של האתר מכילה את המילה לימודים
			System.out.println("title is good!");
		else
			System.out.println("title not good!");
		
		String url = driver.getCurrentUrl(); //שמירת כתובת האתר בתוך משתנה
		System.out.println("the url is: "+ url); // הדפסה לקונסול של כתובת האתר
		//מילוי הפרטים בטופס ההרשמה
		driver.findElement(By.id("wpforms-1609-field_2")).sendKeys("igal");
		 
		//WebElement igal = driver.findElement(By.id("wpforms-1609-field_2")); // just to define webelmetns for arrlist.
		//יצירה של LIST  מערך לצורך בחירה של מקצוע מן הרשימה
		 List<WebElement> tablelist = driver.findElements(By.name("wpforms[fields][3]"));
		tablelist.get(1); //הרשמה לקורס הנדסת תוכנה
		
		 
		 //מילוי פירטיי האימייל שלי
		 driver.findElement(By.id("wpforms-1609-field_7")).sendKeys("igal.neeman@gmail.com");
		 //מילוי מספר הטלפון שלי בטבלה
		 driver.findElement(By.id("wpforms-1609-field_4")).sendKeys("0526020093");
		 
		 //לחיצה על הכפתור SUBMIT
		 driver.findElement(By.id("wpforms-submit-1609")).click();
		 
		 
		 System.out.println("filling informations ... wait for the email!");
		 
		//	 15 שניות לבדוק שהמייל מגיע אני רוצה שהאוטומציה תמתין קצת ולכן
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //WATING15 second for email
		 
		ScreenRecorderUtil.stopRecord(); // הפסקת צילום של הוידאו

		driver.quit();// סגירת הדפדפן והריגה של הפרוסס
	}

}
