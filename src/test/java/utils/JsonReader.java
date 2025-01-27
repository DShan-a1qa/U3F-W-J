package utils;

import aquality.selenium.browser.AqualityServices;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonReader {
    public final String RESOURCES_PATH = "src/test/resources/";
    private final Gson GSON = new Gson();

    public <T> T deserializeJson(String filePath, Class<T> tClass) {
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().error("Settings file %s not found or incorrect. Error msg: %s".formatted(filePath, e));
            throw new RuntimeException(e);
        }
    }
}
