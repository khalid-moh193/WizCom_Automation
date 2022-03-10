import Pages.CheckoutPage;
import Pages.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Add To Cart")
public class WixSiteTest extends BaseTestClass {
    HomePage home;
    CheckoutPage checkout;

    @Test(description = "open shop then click on a product and add it to your cart ")
    public void AddToCartFunctionality() {
        home = new HomePage(driver);
        home.navigateToWixSite()
                .clickOnShopsTab()
                .hoverAndClickOverProduct(4)
                .chooseColor()
                .selectQuantity(2)
                .clickOnAddToCart()
                .clickOnViewMore();

        checkout = new CheckoutPage(driver);
        doAssertEqual(checkout.getPrice(), "75", "Price is not as expected");
        checkout.clickOnCheckout();

        softAssert.assertAll();
    }

}
