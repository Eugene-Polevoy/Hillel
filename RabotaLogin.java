import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RabotaLogin {
    WebDriver driver;

    @Before
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rabota.ua/");
        System.out.println("Открылся сайт https://rabota.ua/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//form[@id='aspnetForm']/header/div[@class='f-header-fixed-wrapper']//div[@class='f-header fd-f-between-middle']/div/ul/li[5]/a[@href='#']/label")).click();
        System.out.println("Нажата кнопка Войти");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='divSidebarName']/input[@name='ctl00$Sidebar$login$txbLogin']")).sendKeys("eugenegreat22@gmail.com");
        System.out.println("Введен Email");

    }

    @Test
    public void testCorrectPassTest() throws InterruptedException {

        driver.findElement(By.xpath("//div[@id='divSidebarPassword']/input[@name='ctl00$Sidebar$login$txbPassword']")).sendKeys("Z221997");
        System.out.println("Введен корректный пароль");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ctl00_Sidebar_login_lnkLogin\"]")).click();
        System.out.println("Нажата кнопка Войти");
        Thread.sleep(1000);
        Assert.assertNotNull( driver.findElement(By.xpath("//div[@id='newheader']/div//ul[@class='f-reset-list fd-f-around styles__newheader-menulist___i0ADm']/li[6]/a[@href='#']/label")) );
        System.out.println("Произошла проверка");
        Thread.sleep(2000);
        System.out.println("Все прошло успешно");
    }

    @Test
    public void testFailedPassTest() throws InterruptedException {

        driver.findElement(By.xpath("//div[@id='divSidebarPassword']/input[@name='ctl00$Sidebar$login$txbPassword']")).sendKeys("Z221997111");
        System.out.println("Введен не верный пароль");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ctl00_Sidebar_login_lnkLogin\"]")).click();
        System.out.println("Нажата кнопка Войти");
        Thread.sleep(1000);
        Assert.assertNotNull( driver.findElement(By.xpath("//*[@id=\"ctl00_content_ZoneLogin_pLogin\"]/strong")) );
        System.out.println("Произошла проверка");
        Thread.sleep(2000);
        System.out.println("Все прошло успешно");
    }
    @After
    public void quit(){
        driver.quit();
        System.out.println("Выход с драйвера");
    }
}
