package demowebshop_GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist methods for webdriver
 */


public class WebUtilityDemoshop {
	
		/**
		 * This methods is used to maximize browser
		 * 
		 * @param driver
		 */
		public void toMaximize(WebDriver driver) {
			driver.manage().window().maximize();
		}

		/**
		 * This methods is used to minimize browser
		 * 
		 * @param driver
		 */
		public void toMinimize(WebDriver driver) {
			driver.manage().window().minimize();
		}

		/**
		 * This method will wait until webelements loaded in webpage
		 * 
		 * @param driver
		 */
		public void toWaitElement(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}

		/**
		 * This method will wait until the element is clickable
		 * 
		 * @param driver
		 * @param ele
		 */
		public void waitUntilElementClickable(WebDriver driver, WebElement ele) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}

		/**
		 * This method will wait until the element is visible
		 * 
		 * @param driver
		 * @param ele
		 */
		public void visibilityOfElement(WebDriver driver, WebElement ele) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(ele));
		}

		/**
		 * This method is used to handle dropdown by using index value
		 * 
		 * @param element
		 * @param index
		 */
		public void toHandleDropdown(WebElement element, int index) {
			Select select = new Select(element);
			select.selectByIndex(index);
		}

		/**
		 * This method is used to handle dropdown by using value
		 * 
		 * @param element
		 * @param value
		 */
		public void toHandleDropdown(WebElement element, String value) {
			Select select = new Select(element);
			select.selectByValue(value);
		}

		/**
		 * This method is used to handle dropdown by using text
		 * 
		 * @param text
		 * @param element
		 */
		public void toHandleDropdown(String text, WebElement element) {
			Select select = new Select(element);
			select.selectByVisibleText(text);
		}

		/**
		 * This method is used to perform move element
		 * 
		 * @param driver
		 * @param element
		 */
		public void toMouseHover(WebDriver driver, WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
		}

		/**
		 * This method is used to perform double click
		 * 
		 * @param driver
		 * @param element
		 */
		public void toDoubleClick(WebDriver driver, WebElement element) {
			Actions action = new Actions(driver);
			action.doubleClick(element).perform();
		}

		/**
		 * This method is used to perform right click
		 * 
		 * @param driver
		 * @param element
		 */
		public void toRightClick(WebDriver driver, WebElement element) {
			Actions action = new Actions(driver);
			action.contextClick(element).perform();
		}

		/**
		 * This method is used to perform drag and drop
		 * 
		 * @param driver
		 * @param src
		 * @param target
		 */
		public void toDragAndDrop(WebDriver driver, WebElement src, WebElement target) {
			Actions action = new Actions(driver);
			action.dragAndDrop(src, target);
		}

		/**
		 * This method is used to switch frame by using index
		 * 
		 * @param driver
		 * @param index
		 */
		public void toHandleFrame(WebDriver driver, int index) {
			driver.switchTo().frame(index);
		}

		/**
		 * This method is used to switch frame by using id or name
		 * 
		 * @param driver
		 * @param name_id
		 */
		public void toHandleFrame(WebDriver driver, String name_id) {
			driver.switchTo().frame(name_id);
		}

		/**
		 * This method is used to switch frame by using webelement
		 * 
		 * @param driver
		 * @param element
		 */
		public void toHandleFrame(WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);
		}

		/**
		 * This method is used to switch back frame to immediate page
		 * 
		 * @param driver
		 */
		public void toSwitchBackFrame(WebDriver driver) {
			driver.switchTo().parentFrame();
		}

		/**
		 * This method is used to handle alert popup using accept
		 * 
		 * @param driver
		 */
		public void toHandleAlertPopupToAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}

		/**
		 * This method is used to handle alert popup using dismiss
		 * 
		 * @param driver
		 */
		public void toHandleAlertPopupToDismiss(WebDriver driver) {
			driver.switchTo().alert().accept();
		}

		/**
		 * This method is used to handle alert popup using gettext
		 * 
		 * @param driver
		 */
		public String toHandleAlertPopupToGetText(WebDriver driver) {
			Alert popup = driver.switchTo().alert();
			String alertmsg = popup.getText();
			popup.accept();
			return alertmsg;
		}

		/**
		 * This method is used to take screenshot
		 * @param driver
		 * @param screenshotname
		 * @throws IOException 
		 */
		public void toTakeScreenshot(WebDriver driver,String screenshotname) throws IOException {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File temp=ts.getScreenshotAs(OutputType.FILE);
			File src=new File("./errorshots/" + screenshotname + ".png");
			org.openqa.selenium.io.FileHandler.copy(temp, src);
		}

		/**
		 * This method use to switch into multiple window
		 * @param driver
		 * @param partialWindowHandle
		 */
		public void  toSwitchWindow(WebDriver driver,String partialWindowHandle) {
			Set<String> allWindowIds = driver.getWindowHandles();
			for(String id:allWindowIds) {
				String windowTitle = driver.switchTo().window(id).getTitle();
				if(windowTitle.contains(partialWindowHandle)) {
					break;
					 
				}
			}
		}
		

		
		/**
		 * This method used to clase the browser
		 * @param driver
		 */
		public void toCloseBrowser(WebDriver driver) {
			driver.quit();
		}


}
