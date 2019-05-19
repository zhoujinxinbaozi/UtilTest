package test;

public class Test1 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("aaa");
        change(s);
        System.out.println(s.toString());
    }

    private static void change(StringBuffer s) {
        s.append("123");
    }
}
