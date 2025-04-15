package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header_PO extends Base_PO{
    private @FindBy(id = "search17")
    WebElement search_Bar_TextField;

    private @FindBy(id = "label[for='deichmann-de-women_19']")
    WebElement search_Bar_Women_Button;

    private @FindBy(css = "label[for='deichmann-de-men_19']")
    WebElement search_Bar_Men_Button;

    private @FindBy(css = "label[for='deichmann-de-children_19']")
    WebElement search_Bar_Children_Button;

    private @FindBy(className = "suggestion-link")
    WebElement search_Bar_suggestion;

    public Header_PO() { super();}

    public void clickOn_Search_Bar() {
        waitForWebElementAndClick(search_Bar_TextField);
    }

    public void enterUnique_Text() {
        sendKeys(search_Bar_TextField,"sneaker");
    }

    public void clickUnique_Category() {
        waitForWebElementAndClick(search_Bar_Men_Button);
    }

    public void clickFirst_Suggestion() {
        waitForWebElementAndClick(search_Bar_suggestion);
    }
}
