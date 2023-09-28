package amazon.pageComponents.home;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("page:base_url")
public class HomePage extends PageObject {

    public static Target SEARCH_TEXT_INPUT = Target.the("search text field").located(By.name("field-keywords"));

    public static Target MIN_PRICE_INPUT = Target.the("min price text field").located(By.id("low-price"));

    public static Target MAX_PRICE_INPUT = Target.the("max price text field").located(By.id("high-price"));

    public static Target PRICE_GO_BUTTON = Target.the("price go button").locatedBy("//input[@class='a-button-input']");

    public static Target DEVICE_COMPATIBILITY_CHECKBOX = Target.the("device compatibility '{0}' checkbox").locatedBy("//div[@id='filters']//li[@aria-label=('{0}')]//a");

    public static Target SEARCH_RESULT_LIST = Target.the("search result list").located(By.cssSelector(".s-search-results .s-asin .a-price-whole"));

}
