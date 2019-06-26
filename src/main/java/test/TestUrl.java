package test;

import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TestUrl {
    public static void main(String[] args) throws UnsupportedEncodingException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "周金鑫");
        jsonObject.put("age", 25);
        String ss = URLEncoder.encode(jsonObject.toString());
        String sss = URLEncoder.encode(jsonObject.toString(), "utf-8");
        System.out.println(ss);
        System.out.println(sss);
    }
}
