package cendy.chen.org.framework.model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AresResponseWrapper {

    //存储返回结果的阻塞队列
    private BlockingQueue<AresResponse> responseQueue = new ArrayBlockingQueue<AresResponse>(1);
    //结果返回时间
    private long responseTime;

    /**
     * 计算该返回结果是否已经过期
     *
     * @return
     */
    public boolean isExpire() {
        AresResponse response = responseQueue.peek();
        if (response == null) {
            return false;
        }

        long timeout = response.getInvokeTimeout();
        if ((System.currentTimeMillis() - responseTime) > timeout) {
            return true;
        }
        return false;
    }

    public static AresResponseWrapper of() {
        return new AresResponseWrapper();
    }

    public BlockingQueue<AresResponse> getResponseQueue() {
        return responseQueue;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }
}
