package com.demo;

import com.demo.actions.Actions;
import com.demo.actions.MainActions;
import com.demo.core.base.BaseTest;
import com.demo.pages.Pages;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


@Epic("Test Epic")
@Feature("Test feature")
@Owner("QA Yaroslav Rymarchuk")
public class FirstTest extends BaseTest {
    private final String query = "Java";

    @Test(description = "GoogleSearchTest")
    public void GoogleSearchTest() {

        Pages.googlePage().openGoogle();

        Pages.googlePage().enterSearchQuery(query);

        Pages.googlePage().clickSearch();

        Assert.assertTrue(Actions.mainActions().checkAvailability(query, Pages.googlePage().getSearchResultsTitles()), "Не всі у всіх запитах є пошукове слово");

        System.out.println("The end of the GoogleSearchTest");
    }
}
