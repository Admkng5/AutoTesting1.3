package ru.yandex.market;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class YandexMarketPage extends BaseTest {
    WebDriver wd;

    private String catalogMarket = "//div[@data-apiary-widget-name='@MarketNode/HeaderCatalogEntrypoint']";
    private String computerSection = "//a/span[text()='Компьютеры']/preceding-sibling::img";
    private String notebookSection = "//a[text()='Ноутбуки']";
    private String priceFrom = "//input[@name='Цена от']";
    private String priceTo = "//input[@name='Цена до']";
    private String checkboxHPNotebook ="//span[text()='HP']";
    private String checkboxLenovoNotebook = "//span[text()='Lenovo']";
    private String notebookName = "//h3[@data-zone-name='title']/a";
    private String hideNotebookList = "//div[@data-zone-name='snippetList']/div";
    private String buttonShowNumberItems = "//span/span[contains(.,'Показывать по')]/ancestor::button/..";
    private String buttonShow12Elements = "//button[text()='Показывать по 12']";
    private String headerSearch = "//input[@id='header-search']";
    private String findButton ="//span[text()='Найти']/..";

    YandexMarketPage(WebDriver wd) {
        this.wd = wd;
    }

    public void openComputerSection() {
        wd.findElement(By.xpath(catalogMarket)).click();
        wd.findElement(By.xpath(computerSection)).click();
    }

    public void notebookSectionClick() {
        wd.findElement(By.xpath(notebookSection)).click();
    }

    public void enterPriceFrom(int priceFromValue) {
        wd.findElement(By.xpath(priceFrom)).sendKeys(String.valueOf(priceFromValue));
    }

    public void enterPriceTo(int priceToValue) {
        wd.findElement(By.xpath(priceTo)).sendKeys(String.valueOf(priceToValue));
    }

    public void checkHPNotebook() {
        wd.findElement(By.xpath(checkboxHPNotebook)).click();
    }

    public void checkLenovoNotebook() {
        wd.findElement(By.xpath(checkboxLenovoNotebook)).click();
    }

    public void show12Items() {
        new WebDriverWait(wd, 10).until(ExpectedConditions.invisibilityOf(wd.findElement(By.xpath(hideNotebookList))));
        wd.findElement(By.xpath(buttonShowNumberItems)).click();
        new WebDriverWait(wd, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(buttonShow12Elements)));
        wd.findElement(By.xpath(buttonShow12Elements)).click();

    }

    public List<WebElement> getSearchResults() {
        new WebDriverWait(wd, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(notebookName)));
        return wd.findElements(By.xpath(notebookName));
    }

    public String getFirstNotebookName() {
        return getSearchResults().get(0).getText();
    }

    public void findFirstNotebook(){
        wd.findElement(By.xpath(headerSearch)).sendKeys(getFirstNotebookName());
        wd.findElement(By.xpath(findButton)).click();
    }

}
