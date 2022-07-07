package forms;

import org.openqa.selenium.By;
import selen.base.BaseForm;
import selen.base.elements.Button;
import selen.base.elements.TextField;
import selen.waits.TypeWait;

import java.util.List;

public class HomeForm extends BaseForm {

    private List<Button> topMenuElements;

    public HomeForm() {
        super(new TextField(By.id("onliner-catalog-purchases"), "unique element home form"));
    }

    public void clickOnCatalog() {
        topMenuElements = getIFactory().getButtons(By.xpath("//li[@class='b-main-navigation__item']/a[@class='b-main-navigation__link']"), "top menu elements", TypeWait.TO_BE_CLICKABLE);
        for (Button button : topMenuElements) {
            if (button.getAttribute("href").contains("catalog")) {
                button.click();
                break;
            }
        }
    }
}