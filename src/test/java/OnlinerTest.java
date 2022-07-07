import forms.CatalogHomeForm;
import forms.ElectronicsForm;
import forms.HomeForm;
import forms.MobileForm;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import selen.base.BaseForm;

import static org.testng.Assert.*;
import static selen.settings.Settings.testData;

public class OnlinerTest extends BaseClass {

    @Test
    public void checkFirstMobilePriceCurrentBrand() {
        HomeForm homeForm = new HomeForm();
        formIsDisplayed(homeForm);
        homeForm.clickOnCatalog();

        CatalogHomeForm catalogHomeForm = new CatalogHomeForm();
        formIsDisplayed(catalogHomeForm);
        catalogHomeForm.clickOnElectronicsButton();

        ElectronicsForm electronicsForm = new ElectronicsForm();
        formIsDisplayed(electronicsForm);
        electronicsForm.moveToMobileField();
        electronicsForm.click();

        MobileForm mobileForm = new MobileForm();
        formIsDisplayed(mobileForm);
        mobileForm.click();
        checkFirstPositionIsCurrentBrand(mobileForm.firstPositionCurrentBrand(testData.get("brand").toString()));
        priceOfFirstMobileIsMoreThenExpected(mobileForm.getFirstMobilePrices());
    }

    @Step("check form is displayed")
    public void formIsDisplayed(BaseForm form) {
        assertTrue(form.isDisplayed(), "unique form element was not displayed");
    }

    @Step("check first position is current brand")
    public void checkFirstPositionIsCurrentBrand(String brand) {
        assertTrue(brand.contains(testData.get("brand").toString()), "first position is not current brand");
    }

    @Step("check price first mobile more then expected")
    public void priceOfFirstMobileIsMoreThenExpected(int price) {
        assertTrue(price > Integer.parseInt(testData.get("prices").toString()), "price not more then expected");
    }
}