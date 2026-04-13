package com.goldbuild.playwright.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import java.util.Arrays;

public class MyOptions implements OptionsFactory {

    @Override
    public Options getOptions() {
        return new Options()
                .setLaunchOptions(new BrowserType.LaunchOptions()
                        .setHeadless(true)
                        .setSlowMo(0)
                        .setArgs(Arrays.asList("--no-sandbox", "--disable-gpu")))
                .setContextOptions(new Browser.NewContextOptions()
                        .setViewportSize(1280, 720)
                        .setBaseURL("https://practicesoftwaretesting.com"));
    }
}
