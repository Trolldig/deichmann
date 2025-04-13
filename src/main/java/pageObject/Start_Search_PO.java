package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.Global_vars;

public class Start_Search_PO extends Base_PO{

    private @FindBy(how = How.ID, using = "search17")
    WebElement search_TextField;

    public Start_Search_PO() { super();}

    public void navigateTo_Homepage(){
        navigateTo_URL(Global_vars.DEICHMANN_HOMEPAGE_URL);
    }
}
