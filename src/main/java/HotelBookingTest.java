import com.sun.javafx.PlatformUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver;

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://www.cleartrip.com/");
        hotelLink.click();

        localityTextBox.sendKeys("Indiranagar, Bangalore");
        try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
        localityTextBox.sendKeys(Keys.RETURN);
       // driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[7]")).click();
        try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
        driver.findElement(By.xpath("//div[@class='monthBlock first']//tr[5]//td[1]")).click();
        try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
        driver.findElement(By.xpath("//div[@class='monthBlock first']//tr[5]//td[2]")).click();
        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();
        try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
        driver.quit();

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        else if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        else if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
        else System.out.println("Failed as only Mac, Windows and, linux is supported ");
    }

}
