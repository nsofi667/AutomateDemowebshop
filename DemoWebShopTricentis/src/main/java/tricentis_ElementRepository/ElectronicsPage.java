package tricentis_ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage {

	//constructor
	public ElectronicsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Electronics']")
	private WebElement electronicText;
	
	@FindBy(xpath="//img[@title='Show products in category Camera, photo']")
	private WebElement cameraLink;
	
	@FindBy(xpath="//img[@title='Show products in category Cell phones']")
	private WebElement cellphoneLink;

	public WebElement getElectronicText() {
		return electronicText;
	}

	public WebElement getCameraLink() {
		return cameraLink;
	}

	public WebElement getCellphoneLink() {
		return cellphoneLink;
	}

	
	
}
