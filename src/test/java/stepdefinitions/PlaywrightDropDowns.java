package stepdefinitions;

import implementations.DropDowns;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class PlaywrightDropDowns {

    @Before("@Dropdown")
    public void launch(){
        DropDowns.launchBrowser();
    }
    @Given("User select {string} from {string}")
    public void selectFruits(String fruitName,String fruits){
        DropDowns.userSelectsFruits();
    }
    @And("User selects {string} and {string} from the {string} dropdown")
    public void selectHeroes(String hero1, String hero2, String hero){
        DropDowns.userSelectHeroes();
    }
    @And("User count all the values from {string} dropdown and print last value")
    public void countOptions(String language){
        DropDowns.userCountOptions();
    }
    @And("User print all the values from {string} dropdown")
    public void selectCountry(String country){
        DropDowns.userSelectsCountry();
    }
    @After("@Dropdown")
    public static void vanish(){
        DropDowns.tearDown();
    }
}
