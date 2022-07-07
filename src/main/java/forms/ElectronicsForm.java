package forms;

import org.openqa.selenium.By;
import selen.base.BaseForm;
import selen.base.elements.Button;
import selen.base.elements.TextField;
import selen.waits.TypeWait;

public class ElectronicsForm extends BaseForm {

    private TextField mobilePopUp = getIFactory().getTextField(By.xpath("//a[contains(@href, '/mobile')]/ancestor::div[@class='catalog-navigation-list__aside-item']"), "button mobile pop up", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);
    private Button mobile;

    public ElectronicsForm() {
        super(new TextField(By.xpath("//div[@data-id='1']"), "unique element electronics form", TypeWait.PRESENCE_OF_ELEMENT_LOCATED));
    }

    public void moveToMobileField() {
        mobilePopUp.actions().moveToElement();
    }

    public void click() {
        mobile = getIFactory().getButtons(By.xpath("//div[@class='catalog-navigation-list__aside-item']//a[contains(@href, '/mobile')][1]"),"current mobile button", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED).get(0);
        mobile.jsMethods().clickOnElement();
    }
}