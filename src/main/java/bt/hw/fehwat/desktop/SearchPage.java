package bt.hw.fehwat.desktop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import bt.hw.fehwat.PageObject;

public class SearchPage extends PageObject {

	@FindBy(id="home-search-keywords")
	protected WebElement search;

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return search.isDisplayed();
	}
	
	public void search(final String text){
		this.search.clear();
		this.search.sendKeys(text);
		
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                WebElement searchResult = d.findElement(By.linkText(text));
                return searchResult.getText().equals(text);
            }
        });
	}
	
	public PropertyResultsPage search(){
		search.submit();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new PropertyResultsPage(driver);
	}
}