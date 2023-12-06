package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.pages.GearPage;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.OverNightDufflePage;
import com.softwaretestingboard.magento.pages.ShoppingCartPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GearTest extends BaseTest {

    HomePage homePage = new HomePage();
    GearPage gearPage = new GearPage();
    OverNightDufflePage overNightDuffle = new OverNightDufflePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //Mouse Hover on Gear Menu
        homePage.mouseHoverOnGearMenu();

        //Click on Bags
        homePage.clickOnBags();

        //Click on Product Name ‘Overnight Duffle’
        gearPage.clickOnOvernightDuffle();

        //Verify the text ‘Overnight Duffle’
        Assert.assertEquals(overNightDuffle.getOverNightDuffelText(), "Overnight Duffle");

        //Change Qty 3
        overNightDuffle.changeQuantityTo3("3");

        //Click on ‘Add to Cart’ Button.
        overNightDuffle.clickOnAddToCart();

        //Verify the text‘You added Overnight Duffle to your shopping cart.’
        Assert.assertEquals(overNightDuffle.getAddToCartText(), "You added Overnight Duffle to your shopping cart.");

        //Click on ‘shopping cart’ Link into message
        overNightDuffle.clickOnShoppingCart();

        //Verify the text ‘Overnight Duffle’
        Assert.assertEquals(shoppingCartPage.getOverNightDuffleText(), "Overnight Duffle");

        //Verify the Qty is ‘3’
        Assert.assertEquals(shoppingCartPage.getQty(), "3");

        //Verify the product price ‘$135.00’
        Assert.assertEquals(shoppingCartPage.getProductPrice(), "$135.00");

        //Change Qty to ‘5’
        shoppingCartPage.changeQtyOfOverNightDuffle("5");

        //Click on ‘Update Shopping Cart’ button
        shoppingCartPage.clickOnUpdateShoppingCart();

        //Verify the product price ‘$225.00’
        Assert.assertEquals(shoppingCartPage.getUpdatedProductPrice(), "$225.00");

    }

}

