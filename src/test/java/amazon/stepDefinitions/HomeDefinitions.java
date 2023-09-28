package amazon.stepDefinitions;

import amazon.actions.home.HomeActions;
import amazon.navigation.NavigateTo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class HomeDefinitions {

    @Given("{actor} navigate to Amazon home page")
    public void userNavigateToAmazonHomePage(Actor actor) {
        actor.wasAbleTo(NavigateTo.AmazonHomePage());
    }
    @When("{actor} enter {string} into the search bar")
    public void usersEnterIntoTheSearchBar(Actor actor,String productName) {
        actor.attemptsTo(HomeActions.searchByProductName(productName));
    }

    @And("{actor} enter the minimum price to ${int} and the maximum price to ${int}")
    public void theyEnterTheMinimumPriceTo$AndTheMaximumPriceTo$(Actor actor,int minPrice, int maxPrice) {
        actor.attemptsTo(HomeActions.enterPriceRangeValue(minPrice,maxPrice));
    }
    @And("{actor} clicks on the Go button")
    public void userClicksOnTheGoButton(Actor actor) {
        actor.attemptsTo(HomeActions.clickOnGoButton());
    }

    @And("{actor} select {string} device compatibility checkbox")
    public void theySelectDeviceCompatibilityCheckbox(Actor actor,String deviceName) {
        actor.attemptsTo(HomeActions.selectDeviceCompatibility(deviceName));
    }

    @Then("{actor} see at list one product that has a price of ${int} to ${int}")
    public void userSeeAtListOneProductThatHasAPriceOf$To$(Actor actor,int minPrice, int maxPrice) {
        actor.attemptsTo(HomeActions.validatePriceRange(actor,minPrice,maxPrice));
    }

}
