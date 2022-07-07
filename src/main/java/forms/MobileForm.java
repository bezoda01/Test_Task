package forms;

import org.openqa.selenium.By;
import selen.base.BaseForm;
import selen.base.elements.Button;
import selen.base.elements.TextField;
import selen.waits.TypeWait;
import java.util.List;

public class MobileForm extends BaseForm {

    private String firstPositionLocator = "//div[@class='schema-product__group'][1]//child::span[contains(text(), '%s')]";
    private Button checkBoxApple = getIFactory().getButton(By.xpath("//label//span[text()='Apple']"), "check box apple mobile", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);
    private List<TextField> firstPositionFields;
    private List<Button> prices;

    public MobileForm() {
        super(new TextField(By.id("schema-segments"), "unique element mobile form", TypeWait.TO_BE_CLICKABLE));
    }

    public void click() {
        checkBoxApple.jsMethods().clickOnElement();
    }

    public String firstPositionCurrentBrand(String brand) {
        firstPositionFields = getIFactory().getTextFields(By.xpath(String.format(firstPositionLocator, brand)), "text fields current brand", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED);
        return firstPositionFields.get(0).getText();
    }

    public int getFirstMobilePrices() {
        prices = getIFactory().getButtons(By.xpath("//div[@class='schema-product__group'][1]//a[contains(@href, 'prices')]//child::span"), "current mobile price", TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED);
        return Integer.parseInt(prices.get(0).getText().split(",")[0]);
    }
}