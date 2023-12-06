package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.WomenJacketsPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WomenTest extends BaseTest {


    HomePage homepage = new HomePage();
    WomenJacketsPage womenPage = new WomenJacketsPage();


    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        homepage.mouseHoverOnWomenMenu();

        //Mouse Hover on Tops
        homepage.mouseHoverOnTops();

        //Click on Jackets
        homepage.clickOnJackets();

        //Select Sort By filter “Product Name”
        womenPage.selectProductNameFilter("Product Name");

        //Verify the products name display in alphabetical order
        Assert.assertEquals(womenPage.getProductList1(), womenPage.getProductList2());

    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        //Mouse Hover on Women Menu
        homepage.mouseHoverOnWomenMenu();

        //Mouse Hover on Tops
        homepage.mouseHoverOnTops();

        //Click on Jackets
        homepage.clickOnJackets();

        //Select Sort By filter “Price”
        womenPage.selectProductNameFilter("Price");

        //Verify the products price display in Low to High
        Assert.assertEquals(womenPage.getPriceList1(), womenPage.getPriceList2());

    }
}