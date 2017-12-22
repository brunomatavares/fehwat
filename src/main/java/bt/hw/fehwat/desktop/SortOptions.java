package bt.hw.fehwat.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bt.hw.fehwat.PageObject;

/**
 * SearchPage extends PageObject class 
 * and represents the web page elements for the sort operation.

 * @author      Bruno Tavares
 * @since       1.0
 */

public class SortOptions extends PageObject {

    @FindBy(id="sortByPrice")
    private WebElement sortByPrice;
    
    @FindBy(id="sortByRating")
    private WebElement sortByRating;
    
    @FindBy(id="sortByDistance")
    private WebElement sortByDistance;
    
    @FindBy(id="sortByName")
    private WebElement sortByName;

    public SortOptions(WebDriver driver) {
        super(driver);
    }

    /**
     * Sort by price
     */
    public void sortByPrice() {
        sortByPrice.click();
    }

    /**
     * Sort by rating
     */
    public void sortByRating() {
        sortByRating.click();
    }
    
    /**
     * Sort by distance
     */
    public void sortByDistance() {
        sortByDistance.click();
    }

    /**
     * Sort by name
     */
    public void sortByName() {
        sortByName.click();
    }
}
