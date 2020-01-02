//package json;
//
//import json.Entity.Student;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//public class Main {
//
//    public static void main(String[] args) {
////        objectToJson();
//        jsonToObject();
//    }
//
//    private static void jsonToObject() {
//        String objStr = "{\"local\":\"beijing\",\"name\":\"zhoujinxin\"}";
//        JSONObject jsonObject = JSONObject.fromObject(objStr);
//        Student stu = (Student)JSONObject.toBean(jsonObject, Student.class);
//        System.out.println(stu.getLocal());
//        System.out.println(stu.getName());
//
//        String arrayStr = "[{\"local\":\"beijing\",\"name\":\"zhoujinxin\"}]";
//        JSONArray jsonArray = JSONArray.fromObject(arrayStr);
//        for(int i = 0; i < jsonArray.size(); i ++){
//            Object obj = jsonArray.get(i);
//            JSONObject jsonObjectTemp = JSONObject.fromObject(obj);
//            Student student = (Student)jsonObjectTemp.toBean(jsonObjectTemp, Student.class);
//            System.out.println(student.getName());
//            System.out.println(student.getLocal());
//        }
//    }
//
//    public static void objectToJson(){
//        Student stu = new Student();
//        stu.setName("zhoujinxin");
//        stu.setLocal("beijing");
//        JSONObject json = JSONObject.fromObject(stu);
//        System.out.println(json.toString());// {"local":"beijing","name":"zhoujinxin"}
//
//        JSONArray jsonArray = JSONArray.fromObject(stu);
//        System.out.println(jsonArray.toString()); // [{"local":"beijing","name":"zhoujinxin"}]
//    }
//}
