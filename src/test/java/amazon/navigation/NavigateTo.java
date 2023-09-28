package amazon.navigation;

import amazon.pageComponents.home.HomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {

    public static Performable AmazonHomePage() {
        return Task.where("{0} opens Amazon Homepage", Open.browserOn().the(HomePage.class));
    }
}
