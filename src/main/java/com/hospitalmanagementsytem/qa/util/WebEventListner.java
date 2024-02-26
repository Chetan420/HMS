package com.hospitalmanagementsytem.qa.util;

import com.hospitalmanagementsytem.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.IOException;

public class WebEventListner extends TestBase implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("Try to accept alert");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        System.out.println("Alert accepted");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        System.out.println("Alert dismissed");
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        System.out.println("Try to dismis alert");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before Navigate to : "+ url +" ");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("After Navigate to : "+ url +" ");
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("navigate back to the previous page");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated to previous page");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Navigating forward to next page");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated forward to next page ");
    }


    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find Element By : " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found Element By : " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on : "+element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Click on : "+element.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Value of the " +element.toString() +"before any changes mode");
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Value of the " +element.toString());
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Switching to Window");
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Switched to window");
    }

    @Override
    public void onException(Throwable exception, WebDriver driver) {
        System.out.println("Exception occured: " +exception);
        try {
            TestUtil.takeScreenShot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        System.out.println("Capturing the screenshot");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        System.out.println("Screen shot has been taken and Saved");
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        System.out.println("Trying to capture the text");
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        System.out.println("Captured the text");
    }
    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }
    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }
}
