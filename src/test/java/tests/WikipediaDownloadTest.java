package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.DownloadPage;
import pages.ArticlePage;
import pages.MainPage;
import utils.FileUtils;
import utils.TestDataReader;

import java.io.File;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class WikipediaDownloadTest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final String articleName = System.getProperty("subject", TestDataReader.getWikipediaData().getArticleName());
    private final String desiredLanguage = System.getProperty(System.getProperty("wiki_language"),TestDataReader.getWikipediaData().getDesiredLanguage());
    private File downloadedFile;

    @Test
    public void wikipediaDownloadTest() {
        Assert.assertTrue(mainPage.state().isDisplayed(), "Wikipedia is not opened");
        mainPage.selectLanguage(desiredLanguage);
        mainPage.inputArticleNameAndSearch(articleName);
        ArticlePage articlePage = new ArticlePage();
        articlePage.navigateToDownloadPage();
        DownloadPage downloadPage = new DownloadPage();
        String filename = downloadPage.getPDFName();
        downloadPage.clickDownloadLink();
        String filePath = getBrowser().getDownloadDirectory() + File.separator + filename;
        downloadedFile = new File(filePath);
        Assert.assertTrue(FileUtils.isFileExist(downloadedFile), "File is not downloaded");
    }

    @AfterMethod
    public void deleteFile() {
        FileUtils.deleteFileIfExist(downloadedFile);
    }
}
