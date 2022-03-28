package leetcode.coding_interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 *
 * @author wangbo
 * @since 2022年03月18日 9:18
 */
public class T39MajorityElement {

    /**
     * 我的解答
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // map.forEach(Map::get> nums.length/2)

        return 0;
    }
}
