package ua.od.maxz.testapi;

import java.io.IOException;
import java.util.Map;

public class TestApi1 {


    public static void main(String[] args) throws IOException {
        Map<String, Object> ipinfo = JsonUtils.decode2Map(HttpReaderSimple.get("http://ip-api.com/json/104.250.126.1"));
        System.out.println("ipinfo = " + ipinfo);
        // --- the same for specific class:
        ipinfo = JsonUtils.fromJson(HttpReaderSimple.get("http://ip-api.com/json/104.250.126.1"), Map.class);
        System.out.println("ipinfo = " + ipinfo);
    }

}
