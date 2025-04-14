package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Global_vars;
import org.openqa.selenium.SearchContext;

public class Start_Search_PO extends Base_PO{

    private @FindBy(how = How.CSS, using = "#cmpwrapper")
    WebElement shadowHost;
    private @FindBy(id = "search17")
    WebElement search_Bar_TextField;

    private @FindBy(id = "deichmann-de-women_19")
    WebElement search_Bar_Women_Button;

    private @FindBy(id = "deichmann-de-men_19")
    WebElement search_Bar_Men_Button;

    private @FindBy(id = "deichmann-de-children_19")
    WebElement search_Bar_Children_Button;

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

    public void clickOn_Search_Bar() {
        waitForWebElementAndClick(search_Bar_TextField);
    }

    public void enterUnique_Text() {
        sendKeys(search_Bar_TextField,"sneaker");
    }

    public void clickUnique_Category() {
        waitForWebElementAndClick(search_Bar_Men_Button);
    }

}
