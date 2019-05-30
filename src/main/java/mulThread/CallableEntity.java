package mulThread;

import java.util.concurrent.Callable;

public class CallableEntity implements Callable {

    @Override
    public Object call() throws Exception {
//        Thread.sleep(1000);
        Main.add();
        return null;
    }
}
