package factory;

public class DriverFactoryProvier {
    public static IWebDriverFactory getDriverFactory(String browserType) {
        return switch (browserType.toLowerCase()) {
            case "chrome" -> new ChromeDriverFactory();
            case "firefox" -> new FireFoxDriverFactory();
            default -> throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        };
    }
}
