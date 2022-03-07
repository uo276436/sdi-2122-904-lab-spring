package com.uniovi.sdi2122904spring.pageobjects;

import com.uniovi.sdi2122904spring.util.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PO_PrivateView extends PO_NavView {
    static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep)
    {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);
        //Seleccionamos el alumnos userOrder
        new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        WebElement score = driver.findElement(By.name("score"));
        score.click();
        score.clear();
        score.sendKeys(scorep);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }
    static public void logout(WebDriver driver)
    {
        //Ahora nos desconectamos y comprobamos que aparece el menú de registro
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        //PO_PrivateView.clickOption(driver, "logout", "text", loginText);
        clickOption(driver, "logout", "class", "btn btn-primary");
    }
    static public void login(WebDriver driver,String user, String password, String checktext)
    {
        //Vamos al formulario de logueo.
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, user, password);
        //Comprobamos que entramos en la página correcta
        PO_View.checkElementBy(driver, "text", checktext);
    }
    static public void clickElement(WebDriver driver,String path, int number) {
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", path);
        elements.get(number).click();
    }
}
