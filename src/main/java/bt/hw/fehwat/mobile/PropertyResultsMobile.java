package bt.hw.fehwat.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import bt.hw.fehwat.PageObject;


public class PropertyResultsMobile extends PageObject {

	@FindBy(id="fabResultsContainer")
	private WebElement results;
	
    @FindBy(xpath="//dd[@class='filterbutton']")
    private WebElement filter;
    
    @FindBy(xpath="//dd[@class='sort-button']")
    private WebElement sort;
    
    @FindBy(xpath="//dd[@class='per-page-button']")
    private WebElement perpage;

	public PropertyResultsMobile(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return sort.isDisplayed();
	}

	
	public PropertyResultsMobile sort(String option){
		this.sort.click();

        (new WebDriverWait(driver, 5)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("//li[@id='sortByName']"));
            }
        });
        
        WebElement sortByName = driver.findElement(By.xpath("//li[@id='sortByName']"));
        sortByName.click();
        try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new PropertyResultsMobile(driver);        
	}
	
	public boolean sortedBy(String option) {
		
        List<WebElement> hostels = driver.findElements(By.xpath("//div[@id=\"fabResultsContainer\"]/div/div/h2/a"));
        List<String> list = new ArrayList<String>(hostels.size());
        for (WebElement webElement : hostels) {
        	list.add(webElement.getText());
        }
        
        String previous = "";

        for (final String current : list) {
            if (current.compareTo(previous) < 0)
               return false;
            previous = current;
        }
        return true;
	}
	
}
