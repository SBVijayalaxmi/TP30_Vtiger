package pom;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement orgLookupImg;
	
	@FindBy(xpath = "//table[@class='lvt small']//tr[@class='lvtColData']/td/a[@title='Organizations']")
	private List<WebElement> lisOfOrganizations;
	
	
	//initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgLookupImg() {
		return orgLookupImg;
	}
	
	public List<WebElement> getLisOfOrganizations() {
		return lisOfOrganizations;
	}

	//Business Logic
	public void clickOnCreateOrgLookupImg()
	{
		orgLookupImg.click();
	}
	
	public void getListOfOrgNames()
	{
		for(WebElement orgName : lisOfOrganizations)
		{
			System.out.println(orgName.getText());
		}
	}
	
	
	
}
