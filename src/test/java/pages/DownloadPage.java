package pages;

import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DownloadPage extends Form {
    private final ILabel PDFNameLabel = getElementFactory().getLabel(By.xpath("//div[@class='mw-electronpdfservice-selection-label-desc']"), "PDF name label");
    private final IButton downloadButton = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Download button");

    public DownloadPage() {
        super(By.xpath("//body[contains(@class, 'mw-special-DownloadAsPdf')]"), "www-wikipedia-org");
    }

    public String getPDFName() {
        return PDFNameLabel.getText();
    }

    public void clickDownloadLink() {
        downloadButton.click();
    }
}
