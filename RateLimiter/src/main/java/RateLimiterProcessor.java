import com.google.common.util.concurrent.RateLimiter;

public final class RateLimiterProcessor {
    /**
     * 限流构件
     */
    private static RateLimiter rateLimiter;

    static {
        rateLimiter = RateLimiter.create(2.0);
    }

    /**
     * 获取令牌
     *
     * @return
     */
    public final static boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }

    /**
     * 设置限流阈值
     */
    public final static void setRate(double rate) {
        rateLimiter.setRate(rate);
    }
}
