package bt.hw.fehwat.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bt.hw.fehwat.desktop.PropertyResultsPage;

public class PropertyResultsMobile extends PropertyResultsPage {

	public PropertyResultsMobile(WebDriver driver) {
		super(driver);
		
		sort = driver.findElement(By.xpath("//dd[@class='sort-button']"));
	}
	
}
