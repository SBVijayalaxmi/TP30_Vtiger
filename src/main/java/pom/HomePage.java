package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage{

	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contcatsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContcatsLink() {
		return contcatsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	//business logics
	public void clickOnOrgLink() 
	{
		organizationLink.click();
	}
	
	public void clickOnContactsLink()
	{
		contcatsLink.click();
	}
	
	public void clickOnOpportunitiesLink()
	{
		opportunitiesLink.click();
	}
	
	public void clickOnLeadsLink()
	{
		leadsLink.click();
	}
	
	
}
