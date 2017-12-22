package bt.hw.fehwat.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import bt.hw.fehwat.desktop.PropertyResultsPage;

/**
 * PropertyResultsMobile extends PropertyResultsPage class 
 * and sets the elements that are represented differently
 * from the results desktop web page.

 * @author      Bruno Tavares
 * @since       1.0
 */

public class PropertyResultsMobile extends PropertyResultsPage {

	public PropertyResultsMobile(WebDriver driver) {
		super(driver);
		
		sort = driver.findElement(By.xpath("//dd[@class='sort-button']"));
	}
	
}
