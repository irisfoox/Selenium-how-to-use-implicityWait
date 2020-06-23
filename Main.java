package second;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver", "C://Program Files//Selenium//drivers//chrome83//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //keeps going if can't find within 10 sec
        driver.get("http://kavim-t.co.il/");
        WebDriverWait waitVar=new WebDriverWait(driver,10);
        try {
        WebElement topmenu=driver.findElement(By.className("top_menu_listitem"));
        //waitVar.until(ExpectedConditions.elementToBeClickable(topmenu));
        //Thread.sleep(5000);
        topmenu.click();
        WebElement search=driver.findElement(By.id("keySearch"));
        //waitVar.until(ExpectedConditions.elementToBeClickable(search));
        //Thread.sleep(5000);
        search.click();
        search.clear();
        search.sendKeys("3");
        WebElement clicker=driver.findElement(By.id("lnkSearch"));
        //waitVar.until(ExpectedConditions.elementToBeClickable(clicker));
        clicker.click();
        WebElement title=driver.findElement(By.cssSelector("[class='title_topline search_general_topborder']"));
        String t=title.getText();
        if(t.contains("3")==true) {System.out.println("valid");}
        else                      {System.out.println("not valid");}
        }catch (Exception ex) {ex.printStackTrace();}
        finally {
        	Thread.sleep(5000);
            driver.close();
            System.out.println("### Test End ###");
        }
	}

}
