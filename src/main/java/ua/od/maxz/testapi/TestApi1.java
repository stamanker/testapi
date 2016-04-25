package ua.od.maxz.testapi;

import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestApi1 {


    public static void main(String[] args) throws IOException {
        Map<String, Object> ipinfo = JsonUtils.decode2Map(HttpReaderSimple.get("http://ip-api.com/json/104.250.126.1"));
        System.out.println("ipinfo = " + ipinfo);
        // --- the same for specific class:
        ipinfo = JsonUtils.fromJson(HttpReaderSimple.get("http://ip-api.com/json/104.250.126.1"), Map.class);
        System.out.println("ipinfo = " + ipinfo);

        // --- 2
        List<Test> t = new ArrayList<>();
        t.add(new Test(1, "abc"));
        t.add(new Test(2, "def"));
        String s = JsonUtils.toJson(t);
        System.out.println("s = " + s);
        List<Test> tests = JsonUtils.fromJson(s, new TypeReference<List<Test>>(){});
        System.out.println("list = " + tests);
    }

}
