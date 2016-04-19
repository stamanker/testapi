package ua.od.maxz.testapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * User: maxz
 * Date: 19.04.2016
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();
    public static final String YYYY_MM_DD_HH_MM_SS = "YYYY-mm-dd HH:mm:ss";
    private static Gson gson = new GsonBuilder().serializeNulls().setDateFormat(YYYY_MM_DD_HH_MM_SS).create(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!

    // Serializes nulls
    public static String getJsonAsString(Map data) {
        return gson.toJson(data);//Set null in ES for null values in PageData
    }


    public static Map<String, Object> decode2Map(String json) {
        return gson.fromJson(json, Map.class);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static <T> T fromJson(byte[] src, Class<T> clazz) {
        try {
            return objectMapper.readValue(src, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static String toJson(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
        mapper.setDateFormat(new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS));
        return mapper;
    }

}
