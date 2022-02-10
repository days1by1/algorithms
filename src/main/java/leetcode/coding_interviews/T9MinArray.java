package leetcode.coding_interviews;

import org.junit.Test;

/**
 * 11：旋转数组的最小数字
 *
 * @author wangbo
 * @since 2021/12/20 23:09
 */
public class T9MinArray {

    @Test
    public void test() {
        int[] arr = {2, 2, 2, 0, 1};
        System.out.println(minArray(arr));
    }

    public int minArray(int[] numbers) {
        int i = 0;
        while (i < numbers.length - 1) {
            if (numbers[i] > numbers[i + 1]) {
                break;
            }
            i++;
        }
        if (i == numbers.length - 1) {
            return numbers[0];
        }
        return numbers[i + 1];
    }
}
