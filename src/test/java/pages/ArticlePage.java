package pages;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ArticlePage extends Form {
    private final IButton toolsSelector = getElementFactory().getButton(By.xpath("//input[@id='vector-page-tools-dropdown-checkbox']"), "Tools selector",  ElementState.EXISTS_IN_ANY_STATE);
    private final ILink downloadPageLink = getElementFactory().getLink(By.xpath("//li[@id='coll-download-as-rl']/a"), "Download button");

    public ArticlePage() {
        super(By.xpath("//span[@class='mw-page-title-main']"), "www-wikipedia-org");
    }

    public void navigateToDownloadPage() {
        toolsSelector.click();
        downloadPageLink.clickAndWait();
    }
}
