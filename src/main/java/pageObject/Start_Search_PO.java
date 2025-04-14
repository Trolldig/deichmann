package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Global_vars;
import org.openqa.selenium.SearchContext;

import java.time.Duration;

public class Start_Search_PO extends Base_PO{

    private @FindBy(how = How.CSS, using = "#cmpwrapper")
    WebElement shadowHost;
    private @FindBy(id = "search17")
    WebElement search_TextField;

    public Start_Search_PO() { super();}

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

    public void clickON_Search_Bar() {
        waitForWebElementAndClick(search_TextField);
        sleepForFiveSeconds();
    }

}
