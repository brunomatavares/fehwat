package bt.hw.fehwat.mobile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import bt.hw.fehwat.desktop.SearchPage;

public class SearchMobile extends SearchPage {

	public SearchMobile(WebDriver driver) {
		super(driver);
	}

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