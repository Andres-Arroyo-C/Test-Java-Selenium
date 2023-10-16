package _1_Objatos;

import org.openqa.selenium.By;

public class PO_StudentRegistration_DemoQA
{
    public static By name = By.id("firstName");
    public static By lastName = By.id("lastName");
    public static By email = By.id("userEmail");
    public static By gender1 = By.xpath("//label[text()=\"Male\"]");
    public static By gender2 = By.xpath("//label[text()=\"Female\"]");
    public static By gender3 = By.xpath("//label[text()=\"Other\"]");
    public static By number = By.id("userNumber");
    public static By date = By.id("dateOfBirthInput");
    public static By hobbies1 = By.id("hobbies-checkbox-1");
    public static By hobbies2 = By.id("hobbies-checkbox-2");
    public static By hobbies3 = By.id("hobbies-checkbox-3");
    public static By picture = By.id("uploadPicture");
    public static By currentAddress = By.id("currentAddress");
    public static By state = By.id("react-select-3-input");
    public static By city = By.id("react-select-4-input");
    public static By submit = By.id("submit");
    public static By modal = By.id("closeLargeModal");

}
