package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends Page {
    public By price = By.id("total-sum");
    public By checkoutBtn = By.xpath("//span[@class='buttonnext2955404246__content']");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("-get checkout Price")
    public String getPrice() {
        return splitPrice();
    }

    @Step("-click on Checkout button")
    public CheckoutPage clickOnCheckout() {
        clickElement(checkoutBtn);
        return this;
    }

    private String splitPrice(){
        String stringToSplit = getElementText(price);
        String[] arrayOfString = stringToSplit.split("[,: ! C $ . 0]+");
        System.out.println(arrayOfString[1]);
        return arrayOfString[1];
    }
}
