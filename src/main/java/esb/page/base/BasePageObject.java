package esb.page.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static esb.webdriver.WebdriverInstance.webdriver;

public class BasePageObject {
    public WebDriver getDriver() {
        return webdriver;
    }

    public static void printError(String errorMessage) {
        throw new AssertionError(errorMessage);
    }

    public Integer getExplicitTimeout() {
        return 10;
    }

    public Boolean isPresent(String element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(getExplicitTimeout()));
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(ElementNotInteractableException.class);
            wait.ignoring(StaleElementReferenceException.class);
            wait.ignoring(NoSuchFrameException.class);

            wait.until(ExpectedConditions.presenceOfElementLocated(element(element)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement waitUntil(ExpectedCondition<WebElement> conditions, Integer timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(conditions);
    }

    public WebElement waitUntilVisible(By by) {
        return waitUntil(ExpectedConditions.visibilityOfElementLocated(by), getExplicitTimeout());
    }

    public WebElement waitUntilClickable(By by, Integer timeout) {
        return waitUntil(ExpectedConditions.elementToBeClickable(by), timeout);
    }

    public WebElement waitUntilPresent(By by) {
        return waitUntil(ExpectedConditions.presenceOfElementLocated(by), getExplicitTimeout());
    }

    public WebElement find(String by) {
        return waitUntilPresent(element(by));
    }

    public By element(String elementValue) {
        String[] locator = elementValue.split("_");
        String locatorType = locator[0];
        String locatorValue = elementValue.substring(elementValue.indexOf("_") + 1);

        switch (locatorType) {
            case "id":
                return By.id(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            case "containsText":
                return By.xpath(String.format("//*[contains(text(), '%s')]", locatorValue));
            case "class":
                return By.className(locatorValue);
            case "css":
                return By.cssSelector(locatorValue);
            default:
                throw new IllegalStateException("Unexpected locator type: " + locatorType);
        }
    }

    public String element(String elementValue, Object args1, Object... args2) {
        String constructedValue;
        try {
            constructedValue = String.format(elementValue, args1, args2[0]);
        } catch (ArrayIndexOutOfBoundsException ignored) {
            constructedValue = String.format(elementValue, args1);
        }

        return constructedValue;
    }

    public void assertIsPresent(String element) {
        if (!isPresent(element)) {
            printError("Element " + element(element) + " not found!");
        }
    }

    public void typeOn(String by, String text) {
        WebElement element = waitUntilVisible(element(by));
        element.clear();
        keyboardFunctionDelete(by);
        element.sendKeys(text);
    }

    public void clickOn(String element) {
        waitUntilClickable(element(element), getExplicitTimeout()).click();
    }

    public void clickOn(String element, Object arg1) {
        clickOn(element(element, arg1));
    }

    public void keyboardFunctionDelete(String by) {
        try {
            find(by).sendKeys(Keys.COMMAND, "a");
            find(by).sendKeys(Keys.DELETE);
        } catch (Exception e) {
            find(by).sendKeys(Keys.CONTROL, "a");
            find(by).sendKeys(Keys.DELETE);
        }
    }
}
