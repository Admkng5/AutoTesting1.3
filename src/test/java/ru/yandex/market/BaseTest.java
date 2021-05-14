package ru.yandex.market;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver wd;

    @BeforeEach
    public void beforeEachTest(){
        System.setProperty("webdriver.chrome.driver",System.getenv("CHROME_DRIVER"));
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().pageLoadTimeout(22, TimeUnit.SECONDS);
        wd.manage().timeouts().setScriptTimeout(22, TimeUnit.SECONDS);
        wd.manage().timeouts().implicitlyWait(22, TimeUnit.SECONDS);
    }

    @AfterEach
    public void afterEachTest(){
        wd.quit();
    }

}
