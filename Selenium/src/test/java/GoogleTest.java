import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Google search to test some By possibilities.
 * @author Leg
 */
public class GoogleTest {
    
    final private String CHROME_PATH = "C:\\ChromeDriver\\chromedriver.exe";
    private WebDriver driver;
    private String baseUrl;
        
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_PATH);
        driver = new ChromeDriver();
        baseUrl = "http://www.google.ca";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    /**
     * Look if the elements are in the page
     */
    @Test
    public void test() {
        driver.get(baseUrl + "/?gws_rd=ssl");
        
        //Find and element by XPATH
        assertTrue(isElementPresent(By.xpath("/html/body[@id='gsr']/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[@class='tsf-p']/div[@class='jsb']/center/input[2]")));

        //Google search
        driver.findElement(By.id("lst-ib")).sendKeys("John smith");
        driver.findElement(By.className("lsb")).click();
        
        //Find an element by ID
        assertTrue(isElementPresent(By.id("viewport")));
        
        //Find an element by NAME
        assertTrue(isElementPresent(By.name("csi")));     
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }


}
