package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${environment}.properties",
})
public interface DemoqaConfig extends Config {
    @Key("stand")
    @DefaultValue("local")
    String getStand();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("119")
    String getBrowserVersion();
}
