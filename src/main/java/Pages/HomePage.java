package Pages;

import Utils.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends Page {
    public By shopsTab = By.id("comp-iy4cwgmq1label");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("-Navigate to Wix site")
    public HomePage navigateToWixSite() {
        openURL(URLs.WIX_SITE.getValue());
        return this;
    }

    @Step("-click on shops")
    public HomePage clickOnShopsTab() {
        clickElement(shopsTab);
        scrollDownByPixel();
        return this;
    }

    @Step("-hover over an element")
    public ProductDetailsPage hoverAndClickOverProduct(int product_number) {
        WebElement product = driver.findElement(By.xpath("//main[@id='PAGES_CONTAINER']//li[" + product_number + "]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();
        clickElement(product);
        return new ProductDetailsPage(driver);
    }


}
