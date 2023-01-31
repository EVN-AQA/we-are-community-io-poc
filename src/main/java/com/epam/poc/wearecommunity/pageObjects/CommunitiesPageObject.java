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
        sendKeyToElement(driver, CommunitiesPageUI.SEARCH_BY, keyword);
    }

    public boolean isCommunityDisplayed(String communityTitle) {
        // TODO: need to remove staticWait and add waitForElementVisible function instead
        staticWait(2);

        boolean isCommunityDisplayed = true;
        List<WebElement> communities = getElements(driver, CommunitiesPageUI.SEARCH_RESULT_BY);
        if (communities.size() > 0) {
            for (WebElement element : communities) {
                if (!communityTitle.contains(element.findElement(CommunitiesPageUI.TEXT_SEARCH_RESULT_BY).getText())) {
                    isCommunityDisplayed = false;
                    break;
                }
            }
        }
        return isCommunityDisplayed;
    }

    public void openPageByCommunityTitle(String communityTitle) {
        clickToElement(driver, CommunitiesPageUI.TEXT_SEARCH_RESULT_BY);
    }
}
