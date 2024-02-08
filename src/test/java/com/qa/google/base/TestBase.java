package com.qa.google.base;

import java.util.logging.Logger;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * 
 * TestBase class will initialize all drivers of web browsers
 *
 */
public class TestBase {

  public static String chromePath = "src/main/resources/chromedriver.exe";
  public static String edgePath = "src/main/resources/msedgedriver.exe";
  public static String fireFoxPath = "src/main/resources/geckodriver.exe";
  public WebDriver driver;

  private static final Logger LOGGER = Logger.getLogger(TestBase.class.getName());

  public WebDriver getDriver() {
    return driver;
  }

  public void setDriver(String browserType) {
    switch (browserType.toLowerCase()) {


      // Firefox driver case
      case "firefox": {
        try {
          LOGGER.info("Quitting firefox incase is already opened ");
          driver.quit();
        } catch (Exception ignored) {
        }
        LOGGER.info("Opening firefox ...");
        System.setProperty("webdriver.gecko.driver", fireFoxPath);
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--lang=en");
        driver = new FirefoxDriver(options);
        break;
      }
      // Edge driver case
      case "edge": {
        try {
          LOGGER.info("Quitting edge incase is already opened ");
          driver.quit();
        } catch (Exception ignored) {
        }
        try {
          System.setProperty("webdriver.edge.driver", edgePath);
          EdgeOptions options = new EdgeOptions();
          options.addArguments("use-fake-ui-for-media-stream");
          options.addArguments("lang=en-GB");
          driver = new EdgeDriver(options);
        } catch (SessionNotCreatedException ex) {
          ex.printStackTrace();
        }
        break;
      }
      // default case is for chrome driver
      default: {
        try {
          LOGGER.info("Quitting Chrome incase is already opened ");
          driver.quit();
        } catch (Exception ignored) {
        }
        LOGGER.info("Opening Chrome ");
        System.setProperty("webdriver.chrome.driver", chromePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);
        break;
      }
    }

  }



}
