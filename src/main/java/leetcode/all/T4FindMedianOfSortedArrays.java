package leetcode.all;

import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 4. 寻找两个正序数组的中位数
 * <p>
 * <p>
 * 注：
 * 1）Arrays.asList(T... a)不能把基本类型的数组转换为列表
 * 2）可以Google Guava类库的Ints.asList()，将基本数据类型的数组转换为列表
 * 3）以上两种asList方法返回的是数组的一个视图，视图意味着，对这个list的操作都会反映在原数组上，
 * 而且这个list是定长的，不支持add、remove等改变长度的方法。
 * 比如使用addAll()方法的时候会报UnsupportedOperationException异常。
 * 参考：https://www.cnblogs.com/zheyangsan/p/6910476.html
 * 4）此题如果限制时间复杂度则困难，否则直接合并再排序就简单
 *
 * @author wangbo
 * @since 2021/11/24 17:06
 */
public class T4FindMedianOfSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4};
        // int[] nums1 = new int[0];
        int[] nums2 = new int[]{1, 3};
        // int[] nums2 = new int[0];
        // double result = findMedianOfSortedArrays(nums1, nums2);
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int totalLeft = (m + n + 1) / 2;

        int left = 0;
        int right = m;

        while (left < right) {
            // int i = left + (right - left + 1) / 2;
            // int i = (left + right + 1) / 2;
            int i = (left + right) / 2;
            int j = totalLeft - i;
            /*if (nums1[i - 1] > nums2[j]) {
                // right = i - 1;
                right = i;
            } else {
                left = i;
            }*/
            if (nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        int i = left;
        int j = totalLeft - i;

        /*int i = m / 2;
        int j = totalLeft - i;
        while (i >= 1 && i <= m && j >= 0 && j < n) {
            if (nums1[i - 1] > nums2[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        while (j >= 1 && j <= n && i >= 0 && i < m) {
            if (nums2[j - 1] > nums1[i]) {
                i++;
                j--;
            } else {
                break;
            }
        }*/

        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) & 1) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }
        return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
    }

    // 我的解答
    public static double findMedianOfSortedArrays(int[] nums1, int[] nums2) {
        // List<Integer> list = Ints.asList(nums1);
        // List<Integer> list2 = Ints.asList(nums2);
        // // 报错：UnsupportedOperationException
        // list.addAll(list2);

        // Integer[] arr = Arrays.stream(nums1).boxed().toArray(Integer[]::new);
        // Integer[] arr2 = Arrays.stream(nums2).boxed().toArray(Integer[]::new);
        // List<Integer> list = Arrays.asList(arr);
        // List<Integer> list2 = Arrays.asList(arr2);
        // // 报错：UnsupportedOperationException
        // list.addAll(list2);

        List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        list.addAll(list2);
        list.sort(Comparator.naturalOrder());
        if ((list.size() & 1) == 1) {
            return list.get(list.size() / 2);
        }
        return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) * 1.0 / 2;
    }
}
