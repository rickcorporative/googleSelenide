package com.demo;

import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Test Epic")
@Feature("Test feature")
@Owner("QA Yaroslav Rymarchuk")
public class FirstTest extends BaseTest {

    @Test(description = "GoogleSearchTest")
    public void GoogleSearchTest() {

        Pages.googlePage().openGoogle();

        Pages.googlePage().enterSearchQuery("Java");

        Pages.googlePage().clickSearch();

        Assert.assertTrue(Pages.googlePage().checkAvailability(), "Не всі у всіх запитах є пошукове слово");

        System.out.println("The end of the GoogleSearchTest");
    }
}
