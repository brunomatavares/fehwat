package bt.hw.fehwat.mobile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import bt.hw.fehwat.desktop.SearchPage;

/**
 * SearchMobile extends SearchPage class 
 * and implements the search operation for
 * the mobile version.

 * @author      Bruno Tavares
 * @since       1.0
 */

public class SearchMobile extends SearchPage {

	public SearchMobile(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Executes the search request
	 * 
	 * @return PropertyResultsPage
	 */
	public PropertyResultsMobile search(){
		search.submit();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new PropertyResultsMobile(driver);
	}
}