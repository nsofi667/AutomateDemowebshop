package electronicsTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import demowebshop_GenericUtility.BaseClass_Demoshop;
import tricentis_ElementRepository.ElectronicsPage;
import tricentis_ElementRepository.HomePage;

public class SelectCameraTest extends BaseClass_Demoshop{

	@Test
	public void toSelectCameraImage_001() {
		HomePage hp= new HomePage(driver);
		hp.getElectronicsLink().click();
		Reporter.log("electronics link clicked",true);
		
		ElectronicsPage ep=new ElectronicsPage(driver);
		String pageTitle = ep.getElectronicText().getText();
		Assert.assertTrue(true);
		Reporter.log(pageTitle+" navigate to electronics page",true);
		
		ep.getCameraLink().click();
		
	}
}
