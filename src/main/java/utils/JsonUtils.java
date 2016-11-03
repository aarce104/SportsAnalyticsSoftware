package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by Abe on 11/2/16.
 */
public class JsonUtils {

    private JsonUtils() {
    }

    public static JsonObject getAsJsonObject(String jsonStr) {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(jsonStr);
        return element.getAsJsonObject();
    }
}
