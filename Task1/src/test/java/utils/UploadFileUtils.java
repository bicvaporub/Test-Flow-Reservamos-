package utils;

import aquality.selenium.browser.AqualityServices;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class UploadFileUtils {
    private static final int DELAY_DURATION = 6000;

    public static void uploadFile(String filePath) {
        try {
            Robot robot = new Robot();
            robot.delay(DELAY_DURATION);
            String absoluteFilePath = new File(filePath).getAbsolutePath();
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(absoluteFilePath), null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(DELAY_DURATION);
        } catch (AWTException e) {
            AqualityServices.getLogger().error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
