package utilty;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static JsonNode rootNode;

    static {
        try {
            File file = new File("src/main/resources/userData.json");
            rootNode = mapper.readTree(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file", e);
        }
    }

    private JsonUtils() {
    }

    public static String getValue(String parent, String key) {
        return rootNode.path(parent).path(key).asText();
    }
}


