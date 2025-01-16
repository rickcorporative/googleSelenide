package com.demo.actions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainActions {

    public void switchToTab(int index) {
        Selenide.switchTo().window(index);
    }

    public void openNewTab() {
        Selenide.executeJavaScript("window.open()");
    }

    public void openLinkFromClipboard() throws IOException, UnsupportedFlavorException {
        String clipboardValue = Toolkit.getDefaultToolkit()
                .getSystemClipboard().getData(DataFlavor.stringFlavor).toString();

        Selenide.executeJavaScript("window.location.href = '" + clipboardValue + "'");
    }

    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public boolean checkAvailability(String searchValue, List<SelenideElement> searchResultsTitles){
        List<SelenideElement> headlines = searchResultsTitles;
        for(int i = 0; i < headlines.size(); i++){
            if(headlines.get(i).getText().toLowerCase() != searchValue.toLowerCase()) {
                return false;
            }
        }
        return true;
    }

}