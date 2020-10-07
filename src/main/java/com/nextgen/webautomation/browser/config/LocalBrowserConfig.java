package com.nextgen.webautomation.browser.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import io.github.bonigarcia.wdm.WebDriverManager;

@Lazy
@Configuration
@Profile("!remote")
public class LocalBrowserConfig {

    @Value("${browser.version}")
    private String bVersion;

    @Bean
    @Scope("browserscope")
    public WebDriver edge() {
        WebDriverManager.edgedriver().browserVersion(this.bVersion).setup();
        return new EdgeDriver();
    }

    @Bean
    @Scope("browserscope")
    public WebDriver firefox() {
        WebDriverManager.firefoxdriver().browserVersion(this.bVersion).setup();
        return new FirefoxDriver();
    }

    @Bean
    @Scope("browserscope")
    public WebDriver chrome() {
        WebDriverManager.chromedriver().browserVersion(this.bVersion).setup();
        return new ChromeDriver();
    }

}