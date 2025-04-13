package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    public static WebDriver getDriver(){
        if(webDriver.get()==null){
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    private static WebDriver createDriver(){
        //WebDriverManager driverManager;
        WebDriver driver = null;

        switch(getBrowserType()){
            case "chrome" -> {
                //WebDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "edge" -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new EdgeDriver(edgeOptions);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType() {
        String browserType = null;
        String browserTypeRemoteValue = System.getProperty("browserType");

        try{
            if (browserTypeRemoteValue == null || browserTypeRemoteValue.isEmpty()) {
                Properties properties = new Properties();
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
                properties.load(file);
                browserType = properties.getProperty("browser").toLowerCase().trim();
            } else {
                browserType = browserTypeRemoteValue;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return browserType;
    }

    public static void cleanupDriver(){
        webDriver.get().quit();
        webDriver.remove();
    }
}
