package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Global_vars;
import org.openqa.selenium.SearchContext;

public class Search_PO extends Base_PO{

    private @FindBy(how = How.CSS, using = "#cmpwrapper")
    WebElement shadowHost;

    private String unique_Part_Of_Search_URL = "search?";

    private String unique_Part_Of_Brand_URL = "marken";

    public Search_PO() { super();}

    public void navigateTo_Homepage(){
        navigateTo_URL(Global_vars.DEICHMANN_HOMEPAGE_URL);
        accept_CMP();
    }

    public void accept_CMP() {
        System.out.println("🟢 Akzeptiere Cookie-Banner im Shadow DOM");
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement cmp_Button_Accept = shadowRoot.findElement(By.cssSelector("#cmpwelcomebtnyes"));
        waitForWebElementAndClick(cmp_Button_Accept);
    }

    public void validate_Search_Page_Is_Displayed(){
        waitForURL_Containing(unique_Part_Of_Search_URL);
        Assert.assertTrue(getCurrentURL().contains(unique_Part_Of_Search_URL), "URL enthält nicht 'search?'");
    }

    public void validate_Brand_Page_Is_Displayed(String brand){
        brand = brand.toLowerCase();
        waitForURL_Containing(unique_Part_Of_Brand_URL);
        Assert.assertTrue(getCurrentURL().contains(unique_Part_Of_Brand_URL) && getCurrentURL().contains(brand),
                "URL enthält nicht " + brand);
    }

}
