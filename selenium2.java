package com.mindtree.selenium1class;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class selenium2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers1/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		
		System.out.println(driver.getCurrentUrl());
	    driver.manage().window().maximize();
	   // Actions a=new Actions(driver);
	   // a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).contextClick().build().perform();
	    //context click=right click
	    
		//a.moveToElement(driver.findElement(By.xpath("//input[@type='text']"))).click().keyDown(Keys.SHIFT).sendKeys("refrigerator").build().perform();
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("refrigerator");
		
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Samsung 192 L 2')]")).click();
	    WebElement b= driver.findElement(By.xpath("//a[contains(@href,'/Samsung-Direct-Refrigerator-RR19A241BGS')][1]//span[@class='a-price-symbol']"));
	    WebElement b1= driver.findElement(By.xpath("//a[contains(@href,'/Samsung-Direct-Refrigerator-RR19A241BGS')][1]//span[@class='a-price-whole']"));
	    String p1=b.getText();
	    String p2=b1.getText();
	    String p3=p1.concat(p2);
	    String p4=".00";
	    String p5=p3.concat(p4);
	     System.out.println(p5);
	     Set <String> ids=driver.getWindowHandles();
	     Iterator <String> it= ids.iterator();
	     String parentid=it.next();
	      String childid=it.next();
	      driver.switchTo().window(childid);
	   
		/*WebElement c= driver.findElement(By.xpath("//span[@class='a-price-symbol']"));
		String p4=c.getText();
		 System.out.println(p4);
		WebElement d= driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		String p5=d.getText();
		 System.out.println(p5);
		 String p6=p4.concat(p5);*/
	      
	      String p6= driver.findElement(By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")).getText();
		 System.out.println(p6);
		 if(p5.equals(p6)) {
			 System.out.println("Both prices are same") ;
		 }
		 else {
			 System.out.println("prices are different");
		 }
		 
		//int w= driver.findElement(By.xpath("//tr[@type='text']")).size(); this gives rows of table
		// String wei=driver.findElement(By.xpath("//tr[@class='']//td[@class=''"))
		
		 int count=driver.findElements(By.xpath("//tr[@class='comparison_other_attribute_row']")).size();
		 for(int i=0;i<count;i++) {
         WebElement e=driver.findElements(By.xpath("//div[@id='dp-container']//th[@class='a-span3 comparison_attribute_name_column comparison_table_first_col']")).get(i);
         String text= e.getText();
         if(text.equals("Item Weight")) {
         WebElement f=driver.findElements(By.xpath("//tr[@class='comparison_other_attribute_row']//td[@class='comparison_sim_items_column comparable_item0']")).get(i);
         String wei=f.getText();
         System.out.println(wei);
}
		 }

		
	}

}
