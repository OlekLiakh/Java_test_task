package library;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

    private static final String screenShotFolderPATH = "./output-tests/Screenshots/";
    private static final String screenShotExtension = ".png";

    public static String getScreenShot(String screenShotName) {
        WebDriver driver = WebDriverInitializer.getDriver();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM_dd_HH_mm_ss");
        String date = dtf.format(LocalDateTime.now());
        String pathname = screenShotFolderPATH + screenShotName + "_" + date + screenShotExtension;
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File(pathname));
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return pathname;
    }
}
