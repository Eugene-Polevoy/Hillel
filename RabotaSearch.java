import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RabotaSearch {
    WebDriver driver;

    @Before
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rabota.ua/");
        System.out.println("Открылся сайт https://rabota.ua/");
        Thread.sleep(1000);


    }

    @Test
    public void testSearchQATest() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='search_holder']/div/div[1]//input[@name='ctl00$content$vacSearch$Keyword']")).clear();
        System.out.println("Поле очищено");
        driver.findElement(By.xpath("//div[@id='search_holder']/div/div[1]//input[@name='ctl00$content$vacSearch$Keyword']")).sendKeys("QA");
        System.out.println("Введен текст QA в поле поиска");
        driver.findElement(By.xpath("//div[@id='search_holder']/div/div[1]//input[@name='ctl00$content$vacSearch$Keyword']")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        System.out.println("нажата кнопка энтр");
        Assert.assertNotNull( driver.findElement(By.xpath("//form[@id='aspnetForm']/div[4]/div[@class='f-vacancylist-wrap fd-f-left ft-c-stretch']/section//div[@class='fd-f-left-middle']/div[1]/h2/span")) );
        System.out.println("Произошла проверка");
		System.out.println("Все прошло успешно");
    }

    @Test
    public void testJavaOdessaTest() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='search_holder']/div/div[1]//input[@name='ctl00$content$vacSearch$Keyword']")).clear();
        System.out.println("Поле очищено");
        driver.findElement(By.xpath("//div[@id='search_holder']/div/div[1]//input[@name='ctl00$content$vacSearch$Keyword']")).sendKeys("Java");
        System.out.println("Введен текст java в поле поиска");
        driver.findElement(By.xpath("//div[@id='search_holder']/div/div[1]//div[@class='f-input f-input-block f-input-icon-left f-input-icon-right']/input[@name='ctl00$content$vacSearch$CityPickerWork$inpCity']")).click();
        System.out.println("Открылся список городов");
        driver.findElement(By.xpath("//body/ul[2]/li[6]/a[@class='f-autocomplete-city-3 ui-corner-all']")).click();
        System.out.println("Выбран город Одесса");
        driver.findElement(By.xpath("//div[@id='search_holder']/div/div[1]//input[@name='ctl00$content$vacSearch$Keyword']")).sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        System.out.println("нажата кнопка энтр");
        driver.findElement(By.xpath("//div[@id='f-vacancylist-sidebar-wrap']/div[3]//span[.='Полная занятость']")).click();
        System.out.println("Выбраная занятость");
        Thread.sleep(3000);
        Assert.assertNotNull( driver.findElement(By.xpath("//div[@id='search_holder']/div//div[@class='f-searchlabels-labelswrapper']/span[3]/p/span[@class='f-searchlabels-label-textplace']")) );
        System.out.println("Произошла проверка");
		System.out.println("Все прошло успешно");
    }
        @After
        public void quit(){
            driver.quit();
            System.out.println("Выход с драйвера");


    }
}
