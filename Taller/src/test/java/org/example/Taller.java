package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class Taller {

    public WebDriver driver;
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void Login(){
        WebElement user;
        user = driver.findElement(By.cssSelector("#user-name"));
        user.click();
        user.sendKeys("standard_user");

        WebElement password;
        password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement botonInicio;
        botonInicio = driver.findElement(By.cssSelector("#login-button"));
        botonInicio.click();
    }

    public void AgregarCarrito(){
        WebElement botonAdd;
        botonAdd = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        botonAdd.click();
        botonAdd = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
        botonAdd.click();
    }
    public void EliminarCarrito(){
        WebElement botonOut;
        botonOut = driver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
        botonOut.click();
    }

    public void Comprobarcarrito(){
        WebElement carrito;
        carrito = driver.findElement(By.cssSelector("#shopping_cart_container > a"));
        carrito.click();

        WebElement checkout;
        checkout = driver.findElement(By.cssSelector("#checkout"));
        checkout.click();
    }
    @Test
    public void test(){
        setUp();
        Login();
        AgregarCarrito();
        EliminarCarrito();
        Comprobarcarrito();
    }
}


