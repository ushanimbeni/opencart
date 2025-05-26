package TestBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;


import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public  Logger logger;
    public Properties properties;

    @BeforeClass(groups={"sanity","master","regression"})
    @Parameters({"browser","os"})
    public void setUp(String br,String os) throws IOException {

        logger=LogManager.getLogger(this.getClass());
        FileReader file=new FileReader("./src//test//resources//config.properties");
        properties = new Properties();
        properties.load(file);
        if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (os.equalsIgnoreCase("Linux")) {
                capabilities.setPlatform(Platform.LINUX);
            } else if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WINDOWS);
            }else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            }
            else {
                System.out.println("Invalid Operating system");
                return;
            }

            switch (br.toLowerCase())
            {
                case "chrome": capabilities.setBrowserName("chrome");break;
                case "firefox": capabilities.setBrowserName("firefox");break;
                default:System.out.println("Invalid browser"); return;

            }

            driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        }
        if(properties.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase())
            {
                case "chrome" :  logger.info("Running on Chrome browder");
                    driver=new ChromeDriver();
                    break;
                case "firefox" : logger.info("Running on firefox browder");
                    driver= new FirefoxDriver();break;
                case "edge" : logger.info("Running on edge browder");
                    driver=new EdgeDriver();break;
                default : System.out.println("Invalid browser...");return;

            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("appurl"));
        driver.manage().window().maximize();
    }

    @AfterClass(groups={"sanity","master","regression"})
    public void tearDown() {
            driver.quit();
    }

    public  String randomString()
    {
       return RandomStringUtils.randomAlphabetic(5);
    }

    public  String randomNumbers()
    {
        return RandomStringUtils.randomNumeric(9);
    }

    public  String randompPwd()
    {
        return RandomStringUtils.randomAlphanumeric(3)+"@"+RandomStringUtils.randomAlphanumeric(4);
    }

    public String randomEmail()
    {
        return RandomStringUtils.randomAlphanumeric(4)+"@gmail.com";
    }

    public String captureScreenShot(String tname) throws IOException
    {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath=System.getProperty("user.dir")+"//screenshots//" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);
        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }

}
