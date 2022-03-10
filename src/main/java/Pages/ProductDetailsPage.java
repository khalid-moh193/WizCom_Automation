package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductDetailsPage extends Page {
    public By quantityField = By.className("_2uERl");
    public By quantityFieldUpArrow = By.className("_11lkb");
    public By blackColor = By.className("ColorPickerItem569978716__radioOuter");
    public By addToCartBtn = By.xpath("//span[@class='buttonnext1002411228__content']");
    public By viewMoreBtn = By.id("widget-view-cart-button");
    public By iFrame = By.className("_2DJg7");
    public By readMoreBtn = By.className("_2V5SI");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }


    @Step("-select quantity")
    public ProductDetailsPage selectQuantity(int quantity) {
        visibilityWait(quantityField);
        WebElement quantityBox = driver.findElement(quantityField);
        Actions actions = new Actions(driver);
        actions.moveToElement(quantityBox).perform();
        for (int i = 1; i <= quantity; i++) {
            clickElement(quantityFieldUpArrow);
        }
        return new ProductDetailsPage(driver);
    }

    @Step("-click on black color")
    public ProductDetailsPage chooseColor() {
        visibilityWait(readMoreBtn);
        clickElement(blackColor);
        return this;
    }

    @Step("-click on Add to Cart")
    public ProductDetailsPage clickOnAddToCart() {
        clickElement(addToCartBtn);
        return this;
    }

    @Step("-click on view more Cart")
    public CheckoutPage clickOnViewMore() {
        visibilityWait(iFrame);
        WebElement iframe = driver.findElement(iFrame);
        driver.switchTo().frame(iframe);
        clickElement(viewMoreBtn);
        driver.switchTo().parentFrame();
        return new CheckoutPage(driver);
    }

}
