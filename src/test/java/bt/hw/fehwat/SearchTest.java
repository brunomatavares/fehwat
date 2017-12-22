package bt.hw.fehwat;

import static org.junit.Assert.*;

import org.junit.Test;

import bt.hw.fehwat.desktop.*;
import bt.hw.fehwat.desktop.PropertyResultsPage.Options;
import bt.hw.fehwat.mobile.*;

public class SearchTest extends WebUITest {

	private final String SEARCH_QUERY = "Dublin, Ireland";
	
	private void search(){
		driver.get(URL_HOSTELWORLD);
		
        SearchPage searchPage = new SearchPage(driver);
        assertTrue(searchPage.isInitialized());
        
        searchPage.search(SEARCH_QUERY);
        PropertyResultsPage propertyResultsPage = searchPage.search();
        assertTrue(propertyResultsPage.isInitialized());        
	}
	
	private void isSortedByName(){
		driver.get(URL_HOSTELWORLD);
		
        SearchPage searchPage = new SearchPage(driver);
        assertTrue(searchPage.isInitialized());
        
        searchPage.search(SEARCH_QUERY);
        PropertyResultsPage propertyResultsPage = searchPage.search();
        assertTrue(propertyResultsPage.isInitialized());
                
        propertyResultsPage.sort(Options.NAME);
        assertTrue(propertyResultsPage.isSortedBy(Options.NAME));
	}
	
	@Test
	public void searchIn412by732(){		        
        driver.manage().window().setSize(SMALL_DIMENSION);
        driver.get(URL_HOSTELWORLD);
        SearchMobile searchMobile = new SearchMobile(driver);
        assertTrue(searchMobile.isInitialized());
        
        searchMobile.search(SEARCH_QUERY);
        PropertyResultsMobile propertyResultsMobile = searchMobile.search();
        assertTrue(propertyResultsMobile.isInitialized());
        
        assertFalse(propertyResultsMobile.isSortedBy(Options.NAME));
        propertyResultsMobile.sort(Options.NAME);
        assertTrue(propertyResultsMobile.isSortedBy(Options.NAME));
        
	}
	
	@Test
	public void isSortedByNameIn412by732(){		        
        driver.manage().window().setSize(SMALL_DIMENSION);
        driver.get(URL_HOSTELWORLD);
        SearchMobile searchMobile = new SearchMobile(driver);
        assertTrue(searchMobile.isInitialized());
        
        searchMobile.search(SEARCH_QUERY);
        PropertyResultsMobile propertyResultsMobile = searchMobile.search();
        assertTrue(propertyResultsMobile.isInitialized());
        
        propertyResultsMobile.sort(Options.NAME);
        assertTrue(propertyResultsMobile.isSortedBy(Options.NAME));        
	}
		
	@Test
	public void searchIn768by1024(){		
        driver.manage().window().setSize(MEDIUM_DIMENSION);      
        search();
	}
	
	@Test
	public void isSortedByNameIn768by1024(){		
        driver.manage().window().setSize(MEDIUM_DIMENSION);      
        isSortedByName();
	}
	
	@Test
	public void searchInFullScreen(){
        driver.manage().window().maximize();        
        search();
	}
	
	@Test
	public void isSortedByNameInFullScreen(){
        driver.manage().window().maximize();        
        isSortedByName();
	}
}