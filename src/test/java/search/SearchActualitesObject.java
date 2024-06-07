package search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchActualitesObject {

	public final static String ACTUALITES_BUTTON_XPATH = "/html/body/div[1]/div/div/div[2]/div/nav/ul/li[6]/a";
	public final static String ACTUALITES_TITLE_XPATH = "/html/body/div[4]/div/section/div/div[1]/h1";
	public final static String INPUT_XPATH = "/html/body/div[4]/div/section/div/div[2]/div/div[1]/form/div/div[1]/input";
	public final static String SEARCH_BUTTON_XPATH = "/html/body/div[4]/div/section/div/div[2]/div/div[1]/form/div/div[3]/button";
	public final static String SEARCH_RESULT_XPATH = "/html/body/div[4]/div/section/div/div[2]/div/div/div[2]/div/div/div/div[2]/h4/a";
	
	
	// declaration des elements web par l annotation findBy avec les selecteurs identifies
	@FindBy(how = How.XPATH, using = ACTUALITES_BUTTON_XPATH)
	public static WebElement actualites_button;

	@FindBy(how = How.XPATH, using = ACTUALITES_TITLE_XPATH)
	public static WebElement actualites_title;

	@FindBy(how = How.XPATH, using = INPUT_XPATH)
	public static WebElement input;

	@FindBy(how = How.XPATH, using = SEARCH_BUTTON_XPATH)
	public static WebElement search_button;
	
	@FindBy(how = How.XPATH, using = SEARCH_RESULT_XPATH)
	public static WebElement search_result;
	
	
	public void choisirActualitesMenu() {
		actualites_button.click();
	}
	
	public String getPageTitle() {
		return actualites_title.getText();
	}
	
	public void inputSearch(String searchWord) {
		 input.sendKeys(searchWord);
	}
	
	public void searchButtonClick() {
		search_button.click();
	}
	
	public String getSearchResult() {
		return search_result.getText();
	}
}
