package ru.yandex.market;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

public class YandexPage {

    WebDriver wd;

    WebElement marketButton;

    YandexPage(WebDriver wd) {
        this.wd = wd;
        marketButton = wd.findElement(By.xpath("//a[@data-id='market']"));
    }

    public boolean goMarket() {
        marketButton.click();
        for (String browserTab : wd.getWindowHandles()) {
            wd.switchTo().window(browserTab);
            if (wd.getTitle().contains("Маркет"))
                return true;
        }
        return false;


    }


    public boolean switchToTab(String tabName) {
        ArrayList<String> tab = new ArrayList<>(wd.getWindowHandles());
        ArrayList<String> tabList = new ArrayList<>();
        for (int i = 0; i < tab.size(); i++) {
            tabList.add(i, wd.switchTo().window(tab.get(i)).getTitle());
            wd.switchTo().window(tab.get(0));
            if (tabList.get(i).equals(tabName)) {
                wd.switchTo().window(tab.get(i));
                return true;
            }
        }
        return false;
    }
}
