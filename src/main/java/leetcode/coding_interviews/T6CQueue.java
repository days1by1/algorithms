package leetcode.coding_interviews;

import leetcode.coding_interviews.bean.CQueue;
import org.junit.Test;

/**
 * @author wangbo
 * @since 2021/12/10 14:40
 */
public class T6CQueue {

    @Test
    public void test(){
        CQueue cQueue = new CQueue();
        cQueue.appendTail(-1);
        cQueue.appendTail(0);
        cQueue.appendTail(1);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

