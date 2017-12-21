package bt.hw.fehwat;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.Dimension;

import bt.hw.fehwat.desktop.*;
import bt.hw.fehwat.mobile.*;

public class SearchTest extends WebUITest {

	@Test
	public void searchIn412by732(){		        
        driver.manage().window().setSize(new Dimension(412, 732));
        driver.get("https://www.hostelworld.com/");
        
        SearchMobile searchMobile = new SearchMobile(driver);
        assertTrue(searchMobile.isInitialized());
        
        searchMobile.search("Dublin, Ireland");
        PropertyResultsMobile propertyResultsMobile = searchMobile.search();
        assertTrue(propertyResultsMobile.isInitialized());

        propertyResultsMobile.sort("Name");
        assertTrue(propertyResultsMobile.sortedBy("Name"));
	}
	
	@Test
	public void searchIn768by1024(){		
        driver.manage().window().setSize(new Dimension(768, 1024));
        driver.get("https://www.hostelworld.com/");        
        
        SearchPage searchPage = new SearchPage(driver);
        assertTrue(searchPage.isInitialized());
        
        searchPage.search("Dublin, Ireland");
        PropertyResultsPage propertyResultsPage = searchPage.search();
        assertTrue(propertyResultsPage.isInitialized());
        
        propertyResultsPage.sort("Name");
        assertTrue(propertyResultsPage.sortedBy("Name"));
	}
	
	@Test
	public void searchFullScreen(){
        driver.manage().window().maximize();        
        driver.get("https://www.hostelworld.com/");
                
        SearchPage searchPage = new SearchPage(driver);
        assertTrue(searchPage.isInitialized());
        
        searchPage.search("Dublin, Ireland");
        PropertyResultsPage propertyResultsPage = searchPage.search();
        assertTrue(propertyResultsPage.isInitialized());

        propertyResultsPage.sort("Name");
        assertTrue(propertyResultsPage.sortedBy("Name"));
	}
}