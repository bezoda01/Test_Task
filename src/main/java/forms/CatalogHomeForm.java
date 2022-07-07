package forms;

import org.openqa.selenium.By;
import selen.base.BaseForm;
import selen.base.elements.Button;
import selen.base.elements.TextField;
import selen.waits.TypeWait;

public class CatalogHomeForm extends BaseForm {

    private Button electronics = getIFactory().getButton(By.xpath("//li[@data-id='1']"), "button electronics", TypeWait.TO_BE_CLICKABLE);

    public CatalogHomeForm() {
        super(new TextField(By.xpath("//div[@class='catalog-bar-main']"), "unique element catalog home form"));
    }

    public void clickOnElectronicsButton() {
        electronics.click();
    }
}