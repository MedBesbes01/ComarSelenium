package search;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.CommonMethods;
import utiles.Setup;
import utiles.WaitMethods;

public class SearchActualitesStepDefinition {

	private WebDriver driver;
	private SearchActualitesObject searchActualitesObject = new SearchActualitesObject();
	private CommonMethods commonMethods = new CommonMethods();
	private WaitMethods waitMethods = new WaitMethods();

	public SearchActualitesStepDefinition() {
		driver = Setup.driver;
		PageFactory.initElements(driver, SearchActualitesObject.class);
	}

	@Given("L utilisateur accède au site web de COMAR")
	public void l_utilisateur_accède_au_site_web_de_comar() throws IOException {
		commonMethods.openURLWithConfigFile("url");
	}

	@When("L utilisateur clique sur la rubrique {string} en haut de la page")
	public void l_utilisateur_clique_sur_la_rubrique_en_haut_de_la_page(String string) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver,
				SearchActualitesObject.ACTUALITES_BUTTON_XPATH, 10);
		searchActualitesObject.choisirActualitesMenu();
	}

	@When("le texte {string} doit être présent sur la page")
	public void le_texte_doit_être_présent_sur_la_page(String actualitesTitle) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver,
				SearchActualitesObject.ACTUALITES_TITLE_XPATH, 10);
		String pageTitle = searchActualitesObject.getPageTitle();
		assertEquals(pageTitle.toLowerCase(), actualitesTitle.toLowerCase());
	}

	@When("L utilisateur entre le mot {string} dans le formulaire de recherche")
	public void l_utilisateur_entre_le_mot_dans_le_formulaire_de_recherche(String search) {
		searchActualitesObject.inputSearch(search);
	}

	@When("L utilisateur clique sur le bouton RECHERCHE")
	public void l_utilisateur_clique_sur_le_bouton_recherche() {
		searchActualitesObject.searchButtonClick();
	}

	@Then("Le texte {string} doit apparaître")
	public void le_texte_doit_apparaître(String requestedResult) {
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, SearchActualitesObject.SEARCH_RESULT_XPATH,
				10);
		String searchResult = searchActualitesObject.getSearchResult();
		assertEquals(searchResult.toLowerCase(), requestedResult.toLowerCase());
	}

}
