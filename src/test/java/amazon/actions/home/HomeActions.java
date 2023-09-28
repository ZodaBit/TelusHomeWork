package amazon.actions.home;

import amazon.pageComponents.home.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class HomeActions {

    public static Performable searchByProductName(String productName) {
        return Task.where(
                "enter {0} value to search text field",
                WaitUntil.the(HomePage.SEARCH_TEXT_INPUT, isVisible()),
                Enter.theValue(productName).into(HomePage.SEARCH_TEXT_INPUT).thenHit(Keys.ENTER));
    }

    public static Performable enterPriceRangeValue(int minPrice, int maxPrice) {
        return Task.where(
                "enter min and max price value",
                WaitUntil.the(HomePage.MIN_PRICE_INPUT, isVisible()),
                WaitUntil.the(HomePage.MAX_PRICE_INPUT, isVisible()),
                Enter.theValue(Integer.toString(minPrice)).into(HomePage.MIN_PRICE_INPUT),
                Enter.theValue(Integer.toString(maxPrice)).into(HomePage.MAX_PRICE_INPUT));
    }

    public static Performable clickOnGoButton() {
        return Task.where(
                "click on go button",
                WaitUntil.the(HomePage.PRICE_GO_BUTTON, isVisible()),
                WaitUntil.the(HomePage.PRICE_GO_BUTTON, isEnabled()),
                WaitUntil.the(HomePage.PRICE_GO_BUTTON, isClickable()),
                Click.on(HomePage.PRICE_GO_BUTTON));
    }

    public static Performable selectDeviceCompatibility(String deviceName) {
        return Task.where(
                "select {0} device compatibility checkbox",
                WaitUntil.the(HomePage.DEVICE_COMPATIBILITY_CHECKBOX.of(deviceName),isVisible()),
                WaitUntil.the(HomePage.DEVICE_COMPATIBILITY_CHECKBOX.of(deviceName), isEnabled()),
                WaitUntil.the(HomePage.DEVICE_COMPATIBILITY_CHECKBOX.of(deviceName), isClickable()),
                Click.on(HomePage.DEVICE_COMPATIBILITY_CHECKBOX.of(deviceName)));
    }

    public static Performable validatePriceRange(Actor actor, int minPrice, int maxPrice) {

        WaitUntil.the(HomePage.SEARCH_RESULT_LIST, isVisible()).forNoMoreThan(Duration.ofSeconds(3));
        WaitUntil.the(HomePage.SEARCH_RESULT_LIST,isPresent());

        List<Integer> searchResultPriceList = (HomePage.SEARCH_RESULT_LIST.resolveAllFor(actor).stream()
                .map(p -> p.getText())
                .filter(price -> !price.isEmpty())
                .map(price -> Integer.parseInt(price))
                .collect(toList()));

        long productOnPriceRange = searchResultPriceList.stream().filter(price -> price >= minPrice && price <= maxPrice)
                .count();

        return Task.where("validate price range", Ensure.that(productOnPriceRange).isGreaterThan(0L));
    }
}
