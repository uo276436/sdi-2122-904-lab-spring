package com.uniovi.sdi2122904spring.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//hice el anterior commit mal
    public class PO_LoginView extends PO_NavView {
        static public void fillLoginForm(WebDriver driver, String usernamep, String passwordp) {
            WebElement username = driver.findElement(By.name("username"));
            username.click();
            username.clear();
            username.sendKeys(usernamep);
            WebElement password = driver.findElement(By.name("password"));
            password.click();
            password.clear();
            password.sendKeys(passwordp);

            //Pulsar el boton de Alta.
            By boton = By.className("btn");
            driver.findElement(boton).click();
        }
    }
