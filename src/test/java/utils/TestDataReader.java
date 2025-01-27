package utils;

import models.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataReader {
    public final String TEST_DATA_PATH = JsonReader.RESOURCES_PATH + "testdata/";
    private final String WIKIPEDIA_DATA_PATH = TEST_DATA_PATH + "WikipediaData.json";

    public WikipediaData getWikipediaData() {
        return JsonReader.deserializeJson(WIKIPEDIA_DATA_PATH, WikipediaData.class);
    }
}
