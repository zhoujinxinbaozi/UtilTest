package properties;

public class test {
    public static void main(String[] args) {
        test t = new test();
        t.sys();
    }

    public void sys(){
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(path);
    }
}
