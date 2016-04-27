package ua.od.maxz.testapi;

import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.*;

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

        // --- 3 reseller
        List<Reseller> resellers = Arrays.asList(
                new Reseller(1, "fn1", "ln1", "a1@a.com", "login1", "slug", new Date(), new Date()),
                new Reseller(2, "fn2", "ln2", "a2@a.com", "login2", "slug", new Date(), new Date())
        );
        String jsonReseller = JsonUtils.toJson(resellers.get(0));
        System.out.println("jsonReseller0 = " + jsonReseller);
        System.out.println("object reseller0 deserialized = " + JsonUtils.fromJson(jsonReseller, Reseller.class));
        System.out.println("---------");
        String jsonResellers = JsonUtils.toJson(resellers);
        System.out.println("jsonResellers = " + jsonResellers);
        System.out.println("object resellers deserialized = " + JsonUtils.fromJson(jsonResellers, new TypeReference<List<Reseller>>(){}));

        // --- 4

        ResellersResponse rr = new ResellersResponse(resellers);
        rr.addResseller(new Reseller(3, "fn3", "ln3", "a3@a.com", "login3", "slug3", new Date(), new Date())); // just example of another way to use

        String rrJson = JsonUtils.toJson(rr);
        System.out.println("s = " + rrJson);

        rr = JsonUtils.fromJson(rrJson, ResellersResponse.class);
        System.out.println("rr = " + rr);
    }

}
