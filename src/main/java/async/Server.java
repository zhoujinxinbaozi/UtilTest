package async;

public class Server {
    public void payToTelecom(WeChat weChatUser){//给中国移动支付
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("02. 向中国电信为用户："+weChatUser.name+"支付"+weChatUser.money+"元");
                System.out.println("03. 收取客户："+weChatUser.name+" 0.1%的手续费");
                new Server().notifyToWeChat(weChatUser);
            }
        }).start();
    }

    public void notifyToWeChat(WeChat weChatUser){
        weChatUser.notifyToUser();
    }
}