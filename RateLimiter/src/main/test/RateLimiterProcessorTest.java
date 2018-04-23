import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RateLimiterProcessorTest {

    //@Test
    public void testTryAcquire() throws Exception {
        assertEquals(true, RateLimiterProcessor.tryAcquire());
    }

    //@Test
    public void testSetRate() throws Exception {
        RateLimiterProcessor.setRate(2.0);
    }

    @Test
    public void testMutileThread() {
        System.out.println("hello");
        RateLimiterProcessor.setRate(0.5);
        int count = 20;
        int result = 0;
        Long currentTime = System.currentTimeMillis();
        while (true) {
            if (RateLimiterProcessor.tryAcquire()) {
                result++;
            }
            if (result >= 10) {
                result = 0;
                System.out.println((System.currentTimeMillis() - currentTime)/1000);
                currentTime = System.currentTimeMillis();
            }
        }
    }
}