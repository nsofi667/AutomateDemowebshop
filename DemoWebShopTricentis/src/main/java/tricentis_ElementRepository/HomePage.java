package tricentis_ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//constructor
		public  HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(linkText="Register")
		private WebElement registerLink;
		
		@FindBy(linkText="Log in")
		private WebElement loginLink;
		
		@FindBy(xpath="//input[@value='Search']")
		private WebElement searchButton;
		
		@FindBy(partialLinkText="Books")
		private WebElement booksLink;
		
		@FindBy(partialLinkText="Computers ")
		private WebElement computersLink;
		
		@FindBy(partialLinkText="Electronics ")
		private WebElement electronicsLink;
		
		@FindBy(partialLinkText="Apparel & Shoes ")
		private WebElement apparelLink;
		
		@FindBy(partialLinkText="Digital downloads ")
		private WebElement digitalLink;
		
		@FindBy(partialLinkText="Gift Cards")
		private WebElement giftcardsLink;
		
		@FindBy(partialLinkText="Jewelry")
		private WebElement jwelleryLink;
		
		@FindBy(linkText="Log out")
		private WebElement logoutLink;
		
		public WebElement getRegisterLink() {
			return registerLink;
		}

		public WebElement getLoginLink() {
			return loginLink;
		}

		public WebElement getSearchButton() {
			return searchButton;
		}

		public WebElement getBooksLink() {
			return booksLink;
		}

		public WebElement getComputersLink() {
			return computersLink;
		}

		public WebElement getElectronicsLink() {
			return electronicsLink;
		}

		public WebElement getApparelLink() {
			return apparelLink;
		}

		public WebElement getDigitalLink() {
			return digitalLink;
		}

		public WebElement getGiftcardsLink() {
			return giftcardsLink;
		}

		public WebElement getJwelleryLink() {
			return jwelleryLink;
		}

		public WebElement getLogoutLink() {
			return logoutLink;
		}

		

}
