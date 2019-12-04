package callShell;

public class Test {
    public static void main(String[] args) throws Exception {
        String shpath = "D:/tar.sh";
        Process ps = Runtime.getRuntime().exec(shpath);
        ps.waitFor();
    }
}
