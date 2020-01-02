package async;

public class TestMain {
    public static void main(String[] args) throws Exception {
        WeChat weChat = new WeChat("LittleLawson", 100);
        weChat.pay();
        Thread.sleep(2000);
    }
}
