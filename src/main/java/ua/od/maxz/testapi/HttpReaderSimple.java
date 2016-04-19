package ua.od.maxz.testapi;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpReaderSimple {

    public static String get(String url) throws IOException {
        URL u = new URL(url);
        String ret = "";
        try (BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                ret += line;
            }
        }
        return ret;
    }

    public static String post(String address) throws Exception {
        URL url = new URL(address);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        try(DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            String params =
                    "login=" +  "" +
                            "&password=" + "" +
                            "&size=10" +
                            "&date=" + "";
            wr.writeBytes(params);
        }
        String ret = "";
        try(InputStream inputStream = con.getInputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ret += line;
            }
        }
        return ret;
    }

}
