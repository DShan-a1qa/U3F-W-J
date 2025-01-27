package pages;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private final IComboBox languageSelector = getElementFactory().getComboBox(By.xpath("//select[@id='searchLanguage']"), "Language selector",  ElementState.EXISTS_IN_ANY_STATE);
    private final ITextBox searchBox = getElementFactory().getTextBox(By.xpath("//input[@id='searchInput']"), "Search box");
    private final IButton submitButton = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Submit button");

    public MainPage() {
        super(By.xpath("//nav[@class='central-featured']"), "www-wikipedia-org");
    }

    public void selectLanguage(String desiredLanguage) {
        languageSelector.selectByValue(desiredLanguage);
    }

    public void inputArticleNameAndSearch(String articleName) {
        searchBox.type(articleName);
        submitButton.clickAndWait();
    }
}
