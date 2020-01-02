//package json.test;
//
//
//import net.sf.json.JSON;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//public class Demo {
//    public static void main(String[] args) {
//        JSONObject result = new JSONObject();
//        JSONArray stateJson = new JSONArray();
//        JSONObject  e1 = new JSONObject();
//        e1.put("type", 0);
//        e1.put("id", "1");
//        e1.put("name", "内容质量差");
//        stateJson.add(e1);
//        stateJson.add(e1);
//        JSONObject jj = new JSONObject();
//        jj.put("statejson", stateJson);
//        jj.put("url", "https://news.58.com/api/uninterestedtags?id=75276634type=news&from=guesslike&statejson=");
//        result.put("uninterest",jj);
//        System.out.println(result.toString());
//    }
//}
