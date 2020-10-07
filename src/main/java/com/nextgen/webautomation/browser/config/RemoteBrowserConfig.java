package com.nextgen.webautomation.browser.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Lazy
@Configuration
@Profile("remote")
public class RemoteBrowserConfig {

	@Value("${hub.host}")
	private String hubHost;

	@Value("${hub.port}")
	private String hubPort;
	
	@Bean
	@Scope("browserscope")
	public WebDriver remoteFirefox() throws MalformedURLException {
		return new RemoteWebDriver(new URL("http:" + this.hubHost + ":" + this.hubPort + "/wd/hub"),
				DesiredCapabilities.firefox());
	}
	
	@Bean
	@Scope("browserscope")
	public WebDriver remoteChrome() throws MalformedURLException {
		return new RemoteWebDriver(new URL("http:" + this.hubHost + ":" + this.hubPort + "/wd/hub"),
				DesiredCapabilities.chrome());
	}

}