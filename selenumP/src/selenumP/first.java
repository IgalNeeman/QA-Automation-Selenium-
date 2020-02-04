package selenumP;
import java.util.List; //���� �� ����� ��� IMPORT ��� ����� ��� ����� �� ���� ERR !!!!
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//��� ����� ������, ���� ������ �� �- JARS + Libs �� �- Driver (selenium-server-3.9.1)
//����� �� ���� VIDEO.JAR  ������� ��������� ����� ScreenRecorder.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class first 
	{

	public static void main(String[] args) throws Exception 
	{

		System.setProperty("webdriver.chrome.driver", "C:/Selenium/driver/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		ScreenRecorderUtil.startRecord("Check"); // ����� ������
		
		driver.get("http://www.getstudy.co.il"); //    ���� ��� - ����� ������ ����� ��� �� ������
		driver.manage().window().maximize(); // ����� ����� �� ������ ����� ����
		String title = driver.getTitle(); // ����� �title ���� ����� 
		System.out.println("page title is: " + title ); //����� �� ������ �������
		
		 driver.findElement(By.className("hustle-icon-close")).click(); //����� ����� ������ �����
		
		//��� ���� ���������� ����� ��� ����
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //WATING
		
		if(title.contains("�������")) //����� �� ������ �� ���� ����� �� ����� �������
			System.out.println("title is good!");
		else
			System.out.println("title not good!");
		
		String url = driver.getCurrentUrl(); //����� ����� ���� ���� �����
		System.out.println("the url is: "+ url); // ����� ������� �� ����� ����
		//����� ������ ����� ������
		driver.findElement(By.id("wpforms-1609-field_2")).sendKeys("igal");
		 
		//WebElement igal = driver.findElement(By.id("wpforms-1609-field_2")); // just to define webelmetns for arrlist.
		//����� �� LIST  ���� ����� ����� �� ����� �� ������
		 List<WebElement> tablelist = driver.findElements(By.name("wpforms[fields][3]"));
		tablelist.get(1); //����� ����� ����� �����
		
		 
		 //����� ������ ������� ���
		 driver.findElement(By.id("wpforms-1609-field_7")).sendKeys("igal.neeman@gmail.com");
		 //����� ���� ������ ��� �����
		 driver.findElement(By.id("wpforms-1609-field_4")).sendKeys("0526020093");
		 
		 //����� �� ������ SUBMIT
		 driver.findElement(By.id("wpforms-submit-1609")).click();
		 
		 
		 System.out.println("filling informations ... wait for the email!");
		 
		//	 15 ����� ����� ������ ���� ��� ���� ���������� ����� ��� ����
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); //WATING15 second for email
		 
		ScreenRecorderUtil.stopRecord(); // ����� ����� �� ������

		driver.quit();// ����� ������ ������ �� ������
	}

}
