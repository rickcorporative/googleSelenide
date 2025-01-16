package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.demo.core.base.PageTools;
import com.demo.utils.SelenideTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.List;


public class GoogleSearchPage extends PageTools {
    private static GoogleSearchPage instance;
    private final By searchBox = By.cssSelector("textarea.gLFyf");
    private final By searchButton = By.cssSelector("input.gNO89b");
    private final By searchResultsTitles = By.cssSelector("div#search h3");


    public static GoogleSearchPage getInstance(){
        if(instance == null){
            instance = new GoogleSearchPage();
        }
        return instance;
    }

    @Step("Opening Google page...")
    public void openGoogle() {
        SelenideTools.openUrl("https://www.google.com/");
    }

    @Step("Entering query...")
    public void enterSearchQuery(String query) {
        getSelenideElement(searchBox).setValue(query);
    }

    @Step("Clicking the search button...")
    public void clickSearch() { getSelenideElement(searchButton).click(); }

    @Step("Getting data from the search")
    public List<SelenideElement> getSearchResultsTitles() {
        return getSelenideElements(searchResultsTitles);
    }


}
