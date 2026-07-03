package Utility;

	import java.time.Duration;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WebDriverUtility {
		
		WebDriver driver = null;
		Actions act;
		WebDriverWait wait;

		public WebDriverUtility(WebDriver driver) {
			this.driver = driver;
			this.act = new Actions(driver);
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		}
		public WebDriverUtility() {

		}
		public WebDriver launchBrowser(String browser) {
			 System.out.println("Browser received = " + browser);
			
				if(browser.equalsIgnoreCase("chrome")) {
	        driver = new ChromeDriver();
	    }
	    else if(browser.equalsIgnoreCase("firefox")) {
	        driver = new FirefoxDriver();
	    }
	    else if(browser.equalsIgnoreCase("edge")) {
	        driver = new EdgeDriver();
	    }
		System.out.println("Driver after launch = " + driver);
	    return driver;
	}

		public void maximizeWindow() {
			driver.manage().window().maximize();
		}

		
		public void fullscreenWindow() {
			driver.manage().window().fullscreen();
		}

		// ===== Basic Waits =====

		/**
		 * Applies implicit wait for the page to load.
		 */
		public void waitForPageLoad() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}

		/**
		 * Waits explicitly until the element is visible.
		 * 
		 * @param element        WebElement to wait for
		 * @param timeOutSeconds Max wait time in seconds
		 */
		public void waitForElementVisible(WebElement element) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		/**
		 * Waits explicitly until the element is clickable.
		 * 
		 * @param element        WebElement to wait for
		 * @param timeOutSeconds Max wait time in seconds
		 */
		public void waitForElementClickable(WebElement element) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

		public void waitAndClick(WebElement element) {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}

		/**
		 * Waits explicitly until an element is invisible.
		 * 
		 * @param element        WebElement to wait for invisibility
		 * @param timeOutSeconds Max wait time in seconds
		 */
		public void waitForElementInvisibility(WebElement element) {
			wait.until(ExpectedConditions.invisibilityOf(element));
		}

		/**
		 * Waits explicitly for specific text to be present in an element.
		 * 
		 * @param element        WebElement
		 * @param text           Expected text
		 * @param timeOutSeconds Max wait time in seconds
		 */
		public void waitForTextInElement(WebElement element, String text) {
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		}

		/**
		 * Waits for the page title to contain given text.
		 * 
		 * @param titlePart      Partial or full title text
		 * @param timeOutSeconds Max wait time in seconds
		 */
		public void waitForTitleContains(String titlePart) {
			wait.until(ExpectedConditions.titleContains(titlePart));
		}

		/**
		 * Waits for the URL to contain given text.
		 * 
		 * @param urlFraction    Partial or full URL text
		 * @param timeOutSeconds Max wait time in seconds
		 */
		public void waitForUrlContains(String urlFraction, int timeOutSeconds) {
			wait.until(ExpectedConditions.urlContains(urlFraction));
		}

		// ===== Dropdown Select Methods =====
		
		
		// Selects dropdown option by index.
		public void select(WebElement element, int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
			
			
		}
		
		
		public void select(WebElement element, String value) {
			Select sel = new Select(element);
			sel.selectByValue(value);
		}
		 
		  
		  //@param element The dropdown WebElement
		 // @param index   Index of the option
		 
		 public void select(String visibleText, WebElement element) {
				Select sel = new Select(element);
				sel.selectByVisibleText(visibleText);
			}

			// ===== Basic Mouse Actions =====

			/**
			 * Performs mouse hover on the given element.
			 * 
			 * @param element The target WebElement
			 */
			public void hover(WebElement element) {
				act.moveToElement(element).build().perform();
			}

			/**
			 * Performs right-click on the given element.
			 * 
			 * @param element The target WebElement
			 */
			public void rightClick(WebElement element) {
				act.contextClick(element).build().perform();
			}

			/**
			 * Performs double-click on the given element.
			 * 
			 * @param element The target WebElement
			 */
			public void doubleClickOnElement(WebElement element) {
				act.doubleClick(element).perform();
			}

			/**
			 * Clicks and holds the given element.
			 * 
			 * @param element The target WebElement
			 */
			public void clickAndHold(WebElement element) {
				act.clickAndHold(element).perform();
			}

			/**
			 * Drags source element and drops onto target element.
			 * 
			 * @param source Source element to drag
			 * @param target Target element to drop onto
			 */
			public void dragAndDrop(WebElement source, WebElement target) {
				act.dragAndDrop(source, target).perform();
			}

			/**
			 * Moves slider input element by offset.
			 * 
			 * @param slider  WebElement slider
			 * @param xOffset Horizontal offset to move
			 */
			public void moveSliderByOffset(WebElement slider, int xOffset) {
				act.clickAndHold(slider).moveByOffset(xOffset, 0).release().perform();
			}
	}

