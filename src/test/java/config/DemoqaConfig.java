package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties",
})
public interface DemoqaConfig extends Config {
    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("119")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com/")
    String getBaseUrl();
}
