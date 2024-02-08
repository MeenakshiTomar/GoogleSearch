package com.qa.google.StepDefinition;

import java.util.List;
import java.util.logging.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.google.pages.BrowserActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchStepDefinition {

  private List<WebElement> secondPage;
  private List<WebElement> thirdPage;
  private BrowserActions browserActions;

  private static final Logger LOGGER = Logger.getLogger(GoogleSearchStepDefinition.class.getName());

  @BeforeTest
  public void setup() {
    browserActions = new BrowserActions();
  }

  @Given("Desired {string} is opened")
  public void desired_is_openned(String browserType) {
    browserActions.setDriver(browserType);
    browserActions.maximize();
  }

  @When("User searches {string} using {string} and navigates to 2nd page")
  public void user_searches_using_and_navigates_to_2nd_page(String link, String searchText)
      throws InterruptedException {
    browserActions.navigate(link);
    browserActions.search("Name", "q", searchText);
    while (!browserActions.isElementPresent("css", "[aria-label=\"Page 2\"]")) {
      LOGGER.info("page is still loading");
    }
    browserActions.click("css", "[aria-label=\"Page 2\"]");
  }

  @When("User checks number of links of 2nd and 3rd page")
  public void user_checks_number_of_links_of_2nd_and_3rd_page() throws InterruptedException {
    secondPage = browserActions.elementsListCreator("css", "[class=\"LC20lb MBeuO DKV0Md\"]");
    browserActions.click("css", "[aria-label=\"Page 3\"]");
    thirdPage = browserActions.elementsListCreator("css", "[class=\"LC20lb MBeuO DKV0Md\"]");
  }

  @Then("Number of links on 2nd page matches 3rd page")
  public void number_of_links_on_2nd_page_matches_3rd_page() {
    Assert.assertEquals("Number of links on both pages do not match", secondPage.size(),
        thirdPage.size());
  }
  
  @AfterTest
  public void endSession() {
    browserActions.quitBrowser();
  }
}
