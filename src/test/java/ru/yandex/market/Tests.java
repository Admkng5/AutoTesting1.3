package ru.yandex.market;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends BaseTest {

    @Test
    public void searchYandexMarket() {

        wd.get("https://yandex.ru");
        YandexPage yandexPage = new YandexPage(wd);
        yandexPage.goMarket();
        YandexMarketPage yandexMarketPage = new YandexMarketPage(wd);
        yandexMarketPage.openComputerSection();
        yandexMarketPage.notebookSectionClick();
        yandexMarketPage.enterPriceFrom(10000);
        yandexMarketPage.enterPriceTo(50000);
        yandexMarketPage.checkHPNotebook();
        yandexMarketPage.checkLenovoNotebook();
        yandexMarketPage.show12Items();
        Assertions.assertEquals(12, yandexMarketPage.getSearchResults().size());
        String firstNotebookName = yandexMarketPage.getFirstNotebookName();
        yandexMarketPage.findFirstNotebook();
        String firstNotebookNameAfterSearch = yandexMarketPage.getFirstNotebookName();
        Assertions.assertEquals(firstNotebookName, firstNotebookNameAfterSearch);

    }

}
