package config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestDataConfig {
    private static final ISettingsFile TEST_DATA_SETTINGS = new JsonSettingsFile("testData.json");

    public static String getFilePath() {
        return TEST_DATA_SETTINGS.getValue("/filePath").toString();
    }
}
