package com.epam.poc.wearecommunity.pageObjects;

import com.epam.poc.wearecommunity.core.BasePage;
import com.epam.poc.wearecommunity.pageUIs.CommunitiesPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommunitiesPageObject extends BasePage {

    private final WebDriver driver;

    public CommunitiesPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpenSuccessfully(String titleName, String urlName) {
        return titleName.equalsIgnoreCase(getPageTitle(driver)) && urlName.equalsIgnoreCase(getCurrentUrl(driver));
    }

    public void searchByKeyword(String keyword) {
        sendKeyToElement(driver, CommunitiesPageUI.INPUT_SEARCH_BY, keyword);
        staticWait(2);
    }

    public boolean isExpectedCommunitiesDisplayed(String keySearch) {
        boolean isCommunityDisplayed = true;

        List<WebElement> communities = getElements(driver, CommunitiesPageUI.TEXT_SEARCH_RESULT_BY);
        if (communities.size() > 0) {
            for (WebElement element : communities) {
                if (!element.getText().toLowerCase().contains(keySearch.toLowerCase())) {
                    isCommunityDisplayed = false;
                    break;
                }
            }
        }
        return isCommunityDisplayed;
    }

    public void openPageByCommunityTitle(String communityTitle) {
        List<WebElement> communities = getElements(driver, CommunitiesPageUI.TEXT_SEARCH_RESULT_BY);
        if (communities.size() > 0) {
            for (WebElement element : communities) {
                if (element.getText().equalsIgnoreCase(communityTitle)) {
                    element.click();
                    break;
                }
            }
        }
    }
}
