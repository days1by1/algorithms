package leetcode.all;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @author wangbo
 * @since 2024年06月29日 18:19
 */
public class No4_FindMedianOfSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {2, 3, 4, 5, 6};
        System.out.println(findMedianOfSortedArrays(nums1, nums2));
    }

    public static double findMedianOfSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return getKthElement(nums1, nums2, len / 2 + 1);
        }
        // 注意：除法运算“/”两侧均为整数时，相当于向下取整，要保留小数部分的话，把除数或者被除数变为浮点数即可
        return (getKthElement(nums1, nums2, len / 2) + getKthElement(nums1, nums2, len / 2 + 1)) / 2.0;
    }

    // 参考官方解答，二分法，时间复杂度 O(log(m+n))
    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            // 调试代码，可以发现 k+index1+index2 为一个定值
            // System.out.println("k = " + k + ", index1 = " + index1 + ", index2 = " + index2);
            // 注意：index==len 的边界情况要放在 k==1 的终止条件之前，否则可能会索引越界，比如对于 [1,2,3,4] 和 [5,6,7,8,9]
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int newIndex1 = Math.min(index1 + k / 2, len1) - 1;
            int newIndex2 = Math.min(index2 + k / 2, len2) - 1;
            // k 的减小是要排除掉 index 到 newIndex 这些数，因为 newIndex 这个数也要排除，所以更新 k 时有“+1”
            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
            // 注意：此处 k 的更新不能直接减去 k/2，因为当 newIndex=index 时，k 只减小了 1
            // k -= k / 2;
        }
    }

}
