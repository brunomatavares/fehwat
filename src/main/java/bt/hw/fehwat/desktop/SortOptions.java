package bt.hw.fehwat.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bt.hw.fehwat.PageObject;

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

    public void sortByPrice() {
        sortByPrice.click();
    }

    public void sortByRating() {
        sortByRating.click();
    }
    
    public void sortByDistance() {
        sortByDistance.click();
    }

    public void sortByName() {
        sortByName.click();
    }
}
