package com.nextgen.webautomation.browser.config;

import java.util.Map;
import java.util.function.Function;

import com.google.common.collect.Maps;

import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class BrowserFactory {

	private static final Map<String, Function<ApplicationContext, WebDriver>> MAP = Maps.newHashMap();

	private static final Function<ApplicationContext, WebDriver> launchChrome = ctx -> ctx.getBean("chrome",
			WebDriver.class);

	private static final Function<ApplicationContext, WebDriver> launchFirefox = ctx -> ctx.getBean("firefox",
			WebDriver.class);

	private static final Function<ApplicationContext, WebDriver> launchEdge = ctx -> ctx.getBean("edge",
			WebDriver.class);

	private static final Function<ApplicationContext, WebDriver> launchRemoteChrome = ctx -> ctx.getBean("remoteChrome",
			WebDriver.class);

	private static final Function<ApplicationContext, WebDriver> launchRemoteFirefox = ctx -> ctx
			.getBean("remoteFirefox", WebDriver.class);

	static {
		MAP.put("chrome", launchChrome);
		MAP.put("firefox", launchFirefox);
		MAP.put("edge", launchEdge);
		MAP.put("remoteChrome", launchRemoteChrome);
		MAP.put("remoteFirefox", launchRemoteFirefox);
	}

	public WebDriver launch(String browserName, ApplicationContext ctx) {
		return MAP.get(browserName).apply(ctx);
	}

}