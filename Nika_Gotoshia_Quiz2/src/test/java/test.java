import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;

public class test
{
    // მხოლოდ პირველი გავუშვი headless mode-ით დანარჩენებზე ვერ ავამუშავე.
    @Test
    public void FirstTask()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver;
        webDriver = new HtmlUnitDriver(true);

        webDriver.get("https://demoqa.com/progress-bar");
        WebElement button = webDriver.findElement(By.id("startStopButton"));
        button.click();
        new WebDriverWait(webDriver, 25).until(ExpectedConditions.visibilityOfElementLocated(By.id("resetButton")));
        System.out.println("100%");
    }

    @Test
    public void SecondTask()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        Select progLanguage = new Select(webDriver.findElement(By.id("dropdowm-menu-1")));
        progLanguage.selectByValue("python");
        List<WebElement> checkBoxs = webDriver.findElements(By.xpath("//div[@id='checkboxes']/label"));

        for (WebElement selectedOption : checkBoxs)
        {
            if (selectedOption.isSelected() == false)
            {
                selectedOption.click();
            }
        }

        WebElement yellowButton = webDriver.findElement(By.cssSelector("input[value='yellow']"));
        yellowButton.click();
    }

    @Test
    public void ThirdTask()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://the-internet.herokuapp.com/iframe");
        webDriver.manage().window().maximize();
        WebElement frame = webDriver.findElement(By.id("mce_0_ifr"));
        webDriver.switchTo().frame(frame);
        WebElement input = webDriver.findElement(By.id("tinymce"));
        input.clear();
        input.sendKeys("here goes");
        webDriver.switchTo().defaultContent();
        WebElement alignCenter = webDriver.findElement(By.cssSelector("button[title='Align center']"));
        alignCenter.click();
    }
}
