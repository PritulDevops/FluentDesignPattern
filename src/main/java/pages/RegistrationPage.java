package pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    String navigationUrl="/auth/register";

    By firstNameCss=By.cssSelector("input[data-test='first-name']");
    By lastNameCss=By.cssSelector("input[data-test='last-name']");
    By dobErrorCss=By.cssSelector("[data-test='dob-error']");
    By registerBtnCss=By.cssSelector("button[data-test='register-submit']");
    By countryDDwnCss=By.cssSelector("select[data-test='country']");
    By phoneErrorCss=By.cssSelector("[data-test='phone-error']");
    By phoneTxtCss=By.cssSelector("input[data-test='phone']");



    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage navigateByUrl(){
        this.driver.get(this.url+navigationUrl);
        return this;
    }


    public RegistrationPage enterFirstName(String name){
        waitAndSendKeys(firstNameCss,name);
        return this;
    }

    public RegistrationPage enterLastName(String name){
        waitAndSendKeys(lastNameCss,name);
        return this;
    }

    public RegistrationPage submitForm(){
        waitAndClick(registerBtnCss);
        return this;
    }

    public boolean isDobErrorDisplayed(){
        return isDisplayed(dobErrorCss);
    }
    public void selectCountry(String country){
        waitAndSelect(countryDDwnCss, country);
    }

    public String getSelectedCountry(){
        return getSelectedOption(countryDDwnCss);
    }
    public String getPhoneError(){
        return getText(phoneErrorCss);
    }
    public boolean isPhoneErrorPresent(){ return isDisplayed(phoneErrorCss);}
    public void enterPhone(String phone){
        waitAndSendKeys(phoneTxtCss,phone);
    }
}
