package com.qa.google.pages;


import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.qa.google.base.TestBase;


/**
 * 
 *
 */
public class BrowserActions extends TestBase {

  public String elementValue;
  
  private static final Logger LOGGER = Logger.getLogger(BrowserActions.class.getName());

  public void navigate(String url) {
    LOGGER.info("In Navigate , trying to navigate to " + url);
    getDriver().get(url);
  }

  public void refresh() {
    getDriver().navigate().refresh();
  }

  public void click(String identifierType, String identifierValue) {
    WebElement elementidentifier = elementCreator(identifierType, identifierValue);
    elementidentifier.click();
  }

  public void clear(String identifierType, String identifierValue) {
    WebElement elementidentifier = elementCreator(identifierType, identifierValue);
    elementidentifier.clear();
  }

  public void search(String identifierType, String identifierValue, String value) {
    WebElement elementidentifier = elementCreator(identifierType, identifierValue);
    elementidentifier.clear();
    elementidentifier.sendKeys(value, Keys.ENTER);
  }

  public void wait(int waitValue) {
    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(waitValue));
  }

  public void closeBrowser() {
    getDriver().close();
  }

  public void quitBrowser() {
    getDriver().quit();
  }

  public void maximize() {
    getDriver().manage().window().maximize();
  }

  public boolean isElementPresent(String identifierType, String identifierValue) {
    try {
      WebElement elementidentifier = elementCreator(identifierType, identifierValue);
      if (Objects.nonNull(elementidentifier) && elementidentifier.isDisplayed()) {
        return true;
      }
    } catch (NoSuchElementException e) {
      return false;
    }
    return false;
  }

  public String getElementValue(String identifierType, String identifierValue) {
    WebElement elementidentifier = elementCreator(identifierType, identifierValue);
    elementValue = elementidentifier.getAttribute("value");
    return elementValue;
  }

  public WebElement elementCreator(String identifierType, String identifierValue) {
    WebElement identifier = null;
    if (identifierType.equalsIgnoreCase("Id")) {
      identifier = getDriver().findElement(By.id(identifierValue));
    } else if (identifierType.equalsIgnoreCase("css")) {
      identifier = getDriver().findElement(By.cssSelector(identifierValue));
    } else if (identifierType.equalsIgnoreCase("xPath")) {
      identifier = getDriver().findElement(By.xpath(identifierValue));
    } else if (identifierType.equalsIgnoreCase("className")) {
      identifier = getDriver().findElement(By.className(identifierValue));
    } else if (identifierType.equalsIgnoreCase("linkText")) {
      identifier = getDriver().findElement(By.linkText(identifierValue));
    } else if (identifierType.equalsIgnoreCase("Name")) {
      identifier = getDriver().findElement(By.name(identifierValue));
    } else if (identifierType.equalsIgnoreCase("partialLinkText")) {
      identifier = getDriver().findElement(By.partialLinkText(identifierValue));
    } else if (identifierType.equalsIgnoreCase("tagName")) {
      identifier = getDriver().findElement(By.tagName(identifierValue));
    }
    return identifier;
  }

  public List<WebElement> elementsListCreator(String identifierType,
      String identifierValue) {
    List<WebElement> identifier = null;
    if (identifierType.equalsIgnoreCase("Id")) {
      identifier = getDriver().findElements(By.id(identifierValue));
    } else if (identifierType.equalsIgnoreCase("css")) {
      identifier = getDriver().findElements(By.cssSelector(identifierValue));
    } else if (identifierType.equalsIgnoreCase("xPath")) {
      identifier = getDriver().findElements(By.xpath(identifierValue));
    } else if (identifierType.equalsIgnoreCase("className")) {
      identifier = getDriver().findElements(By.className(identifierValue));
    } else if (identifierType.equalsIgnoreCase("linkText")) {
      identifier = getDriver().findElements(By.linkText(identifierValue));
    } else if (identifierType.equalsIgnoreCase("Name")) {
      identifier = getDriver().findElements(By.name(identifierValue));
    } else if (identifierType.equalsIgnoreCase("partialLinkText")) {
      identifier = getDriver().findElements(By.partialLinkText(identifierValue));
    } else if (identifierType.equalsIgnoreCase("tagName")) {
      identifier = getDriver().findElements(By.tagName(identifierValue));
    }
    return identifier;
  }
}
