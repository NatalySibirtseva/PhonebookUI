package com.phonebook.fw;

import com.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {
        //enter name
        type(By.cssSelector("input[placeholder='Name']"), contact.getName());
        //enter lastname
        type(By.cssSelector("input[placeholder='Last Name']"), contact.getLastName());
        //enter phone
        type(By.cssSelector("input[placeholder='Phone']"), contact.getPhone());
        //enter email
        type(By.cssSelector("input[placeholder='email']"), contact.getEmail());
        //enter address
        type(By.cssSelector("input[placeholder='Address']"), contact.getAddress());
        //enter description
        type(By.cssSelector("input[placeholder='description']"), contact.getDisctiption());
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text)) return true;
        }
        return false;
    }

    public void deleteContact() {
        //driver.findElement(By.xpath("(//div[@class='contact-item_card__2SOIM'])[last()]")).click();
        //этот xpath вернее
        //driver.findElement(By.xpath("//button[.='Remove']")).click();
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
