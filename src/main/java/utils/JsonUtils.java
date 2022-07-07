package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {

    public static JSONObject readJson(String data) {
        JSONObject object = null;
        JSONParser jsonParser = new JSONParser();
        try {
            object = (JSONObject) jsonParser.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static Map<String, Object> jsonToMap(String data) {
        Map<String, Object> map = null;
        try {
            map = new ObjectMapper().readValue(data, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Map<String, Object> JSONObjectToMap(JSONObject object) {
        Map<String, Object> map = new HashMap<String, Object>();
        for (String key : (Iterable<String>) object.keySet()) {
            Object value = object.get(key);
            map.put(key, value);
        }
        return map;
    }
}