package bt.hw.fehwat.desktop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bt.hw.fehwat.PageObject;

public class PropertyResultsPage extends PageObject {

	@FindBy(id = "fabResultsContainer")
	protected WebElement results;

	@FindBy(xpath = "//dd[@class='filterbutton']")
	protected WebElement filter;

	@FindBy(xpath = "//div[@class='fixedfilters']//div//div//div//div/dl/dd[2]")
	protected WebElement sort;

	@FindBy(xpath = "//dd[@class='per-page-button']")
	protected WebElement perpage;

	@FindBy(xpath = "//div[@id=\"fabResultsContainer\"]/div/div/h2/a")
	protected List<WebElement> hostels;

	private SortOptions sortOptions;

	public enum Options {
		PRICE, NAME, RATING, DISTANCE;
	}

	public PropertyResultsPage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return !hostels.isEmpty();
	}

	public PropertyResultsPage sort(Options option) {
		sort.click();

		sortOptions = new SortOptions(driver);

		switch (option) {
		case PRICE:
			sortOptions.sortByPrice();
			break;
		case NAME:
			sortOptions.sortByName();
			break;
		case RATING:
			sortOptions.sortByRating();
			break;
		case DISTANCE:
			sortOptions.sortByDistance();
			break;
		}

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new PropertyResultsPage(driver);
	}

	public boolean isSortedBy(Options option) {

		List<String> list = new ArrayList<String>(hostels.size());
		List<String> expectedResult = null;
		switch (option) {
		case PRICE:
			//TODO: Implement the PRICE sorted option
			break;
		case NAME:
			for (WebElement webElement : hostels) {
				list.add(webElement.getText());
			}

			expectedResult = new ArrayList<String>(list);
			Collections.sort(expectedResult);
			break;
		case RATING:
			//TODO: Implement the RATING sorted option
			break;
		case DISTANCE:
			//TODO: Implement the DISTANCE sorted option
			break;

		}
		return list.equals(expectedResult);

	}

}
