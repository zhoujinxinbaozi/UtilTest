package xianliu;

import com.google.common.util.concurrent.RateLimiter;

public class AccessLimitService {
    public static AccessLimitService as;


    private AccessLimitService(){

    }

    public static AccessLimitService getInstance(){
        if(as == null)
            return new AccessLimitService();
        return as;
    }

    //每秒只发出5个令牌
    RateLimiter rateLimiter = RateLimiter.create(5);



    /**
     * 尝试获取令牌
     * @return
     */
    public boolean tryAcquire(){
        return rateLimiter.tryAcquire();
    }
}