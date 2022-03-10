package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected void openURL(String url) {
        driver.navigate().to(url);
    }

    protected void visibilityWait(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public String getElementText(By element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
    }

    @Step("-Scroll down")
    public void scrollDownByPixel() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
    }

}


