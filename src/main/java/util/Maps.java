package util;

import java.util.HashMap;

/**
 * @author wangbo
 * @since 2021/12/8 9:30
 */
public class Maps {

    /**
     * 指定HashMap初始容量，避免多次扩容损失性能
     * 参考：https://blog.csdn.net/kevinxxw/article/details/104423093
     */
    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int expectedSize) {
        return new HashMap<>((int) ((float) expectedSize / 0.75F + 1.0F));
    }
}
