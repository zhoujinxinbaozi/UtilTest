package mulThread;

import java.util.concurrent.Callable;

public class CallableEntity implements Callable {

    private int target;

    public CallableEntity(int target) {
        this.target = target;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(11);
        return target;
    }
}
