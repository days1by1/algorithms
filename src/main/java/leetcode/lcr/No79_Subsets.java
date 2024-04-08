package leetcode.lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：LCR 079. 子集
 * 2024/3/19面试字节时遇到的题是此题的改编，求非空子集
 *
 * @author wangbo
 * @created 2024年04月04日 0:16
 */
public class No79_Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        // binaryBitEnumeration
        System.out.println("binaryBitEnumeration: \t" + binaryBitEnumeration(nums));

        // dynamicProgramming
        System.out.println("dynamicProgramming: \t" + dynamicProgramming(nums));

        // dfs
        List<List<Integer>> dfs = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), dfs);
        System.out.println("dfs: \t\t\t" + dfs);

        // dfsPreOrder
        List<List<Integer>> dfsPreOrder = new ArrayList<>();
        dfsPreOrder.add(new ArrayList<>());
        dfsPreOrder(nums, 0, new ArrayList<>(), dfsPreOrder);
        System.out.println("dfsPreOrder: \t" + dfsPreOrder);

        // dfsInOrder
        List<List<Integer>> dfsInOrder = new ArrayList<>();
        dfsInOrder.add(new ArrayList<>());
        dfsInOrder(nums, 0, new ArrayList<>(), dfsInOrder);
        System.out.println("dfsInOrder: \t" + dfsInOrder);

        // dfsPostOrder
        List<List<Integer>> dfsPostOrder = new ArrayList<>();
        dfsPostOrder.add(new ArrayList<>());
        dfsPostOrder(nums, 0, new ArrayList<>(), dfsPostOrder);
        System.out.println("dfsPostOrder: \t" + dfsPostOrder);

        // backtrack
        List<List<Integer>> backtrack = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), backtrack);
        System.out.println("backtrack: \t\t" + backtrack);
    }


    /**
     * 2024/03/20 11:22 新建
     * <p>
     * 2024/04/07 23:39 修改
     * <p>
     * 二进制位枚举（参考主站78题「道法自然」的题解），也叫状态压缩
     * <p>
     * 1、解释
     * <p>
     * 例如对于集合{1, 2, 3}，其中的每个元素都可以选或者不选，共有2^n种选择，即子集个数有2^n个。
     * 用一个长度等于集合元素个数的二进制数来表示集合中每个元素的选择情况，例如000表示一个元素也不选，
     * 001表示选择左侧第1个元素，010表示选择左侧第2个元素，011表示选择左侧第1、2个元素……以此类推，
     * 111表示选择所有元素。
     * <p>
     * 2、变种
     * <p>
     * 若要求非空子集（昨天字节的面试题目），则二进制从001开始计数，即代码里外层for循环的i初始值为1。
     * <p>
     * 3、其他
     *
     * @see <a href="https://www.bilibili.com/video/BV15b411N7XK/">「烧脑面试题：老鼠和毒药问题怎么解？二进制和易经八卦有啥关系？李永乐老师告诉你」</a>
     * @see <a href="https://www.cnblogs.com/welisit/p/12105420.html">囚犯问题：1到100数字偶数活奇数死</a>
     */
    public static List<List<Integer>> binaryBitEnumeration(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {  // 若要求非空子集，此处i的初始值为1
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }


    /**
     * 2024/04/03 11:46
     * <p>
     * 循环枚举/动态规划（参考主站78题「道法自然」、「yukiyama」的题解）
     * <p>
     * 逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集。
     * 本质是动态规划思想，属于较简单的线性动规。
     * 可以这么表示，dp[i]表示前i个数的解集，dp[i] = dp[i - 1] + collections(i)。其中，collections(i)表示把dp[i-1]的所有子集都加上第i个数形成的子集。
     * <p>
     * 【具体操作】
     * 因为空集是任何集合的子集，故解集中一定有空集。令解集一开始只有空集，然后遍历nums，每遍历一个数字，拷贝解集中的所有子集，将该数字与这些拷贝组成新的子集再放入解集中即可。时间复杂度为O(2^n)。
     * 例如[1,2,3]，一开始解集为[[]]，表示只有一个空集。
     * 遍历到1时，依次拷贝解集中所有子集，只有[]，把1加入拷贝的子集中得到[1]，然后加回解集中。此时解集为[[], [1]]。
     * 遍历到2时，依次拷贝解集中所有子集，有[], [1]，把2加入拷贝的子集得到[2], [1, 2]，然后加回解集中。此时解集为[[], [1], [2], [1, 2]]。
     * 遍历到3时，依次拷贝解集中所有子集，有[], [1], [2], [1, 2]，把3加入拷贝的子集得到[3], [1, 3], [2, 3], [1, 2, 3]，然后加回解集中。此时解集为[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]。
     * <p>
     * 【非空子集】
     * 若要求非空子集，可以在以上所求全部子集的基础上去掉第1个元素的空集即可。
     * 也可以改变算法策略，一开始不把空集加入解集中，每遍历一个元素，把该元素加入已有子集中形成新的子集，并加入一个只含该元素的子集。
     *
     * @see #dfsPreOrder
     * @see <a href="https://leetcode.cn/problems/TVdhkn/solutions/1381345/java-100-by-yukiyama-y9vz/">「yukiyama」的题解</a>
     */
    public static List<List<Integer>> dynamicProgramming(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size(); // res长度会改变，所以暂存一下
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<>(res.get(i));
                newSub.add(num);
                res.add(newSub);
            }
        }
        // return res.subList(1, res.size());  // 非空子集
        return res;
    }


    /**
     * 「饭胡啦」的inOrder题解、「灵茶山艾府」backtrack题解。结果取的是叶子节点，相较于「道法自然」的取路径更容易理解。
     * 按「灵茶山艾府」的说法是回溯，输入的视角（选或不选），此处以及后面的{@link #dfsPreOrder}、{@link #dfsInOrder}和{@link #dfsPostOrder}都是先不选再选，
     * 主要是为了方便，若要先选再不选，则在第二步进行进行不选的递归时要撤销选择，`subset.remove(subset.size() - 1)`
     *
     * @see <a href="https://leetcode.cn/problems/subsets/solutions/7683/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/comments/871600">「饭胡啦」的inOrder题解</a>
     * @see #backtrack
     */
    public static void dfs(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        // System.out.println("[DEBUG]dfs entering..." + "i = " + i + ", subset = " + subset);
        subset = new ArrayList<>(subset);
        if (i == nums.length) {
            res.add(subset);
            return;
        }
        dfs(nums, i + 1, subset, res);
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res);
    }


    /**
     * DFS前序遍历（主站78题「道法自然」题解），取的结果是「从根节点到叶子节点的所有路径」，即非叶子节点。
     * <p>
     * ”集合中每个元素的选和不选，构成了一个满二叉状态树，比如，左子树是不选，右子树是选，从根节点到叶子节点的所有路径，构成了所有子集。
     * 可以有前序、中序、后序的不同写法，结果的顺序不一样。本质上，其实是比较完整的中序遍历。“
     * <p>
     * 注意取的结果是「从根节点到叶子节点的所有路径」，也即除了叶子节点外的节点，所以有前中后序的差别。
     * 另外此处以及后面的{@link #dfsInOrder}和{@link #dfsPostOrder}得到的结果是非空子集，需要单独将空集加入res中。
     *
     * @see <a href="https://leetcode.cn/problems/subsets/solutions/7683/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/">「道法自然」题解</a>
     */
    public static void dfsPreOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        // System.out.println("[DEBUG]dfsPreOrder entering..." + "i = " + i + ", subset = " + subset);
        if (i >= nums.length) return;
        subset = new ArrayList<>(subset);

        // 这里
        res.add(subset);
        dfsPreOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        dfsPreOrder(nums, i + 1, subset, res);
    }


    /**
     * DFS中序遍历（「道法自然」的题解），取的结果是「从根节点到叶子节点的所有路径」，即非叶子节点
     *
     * @see #dfsPreOrder
     */
    public static void dfsInOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<>(subset);

        dfsInOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        // 这里
        res.add(subset);
        dfsInOrder(nums, i + 1, subset, res);
    }


    /**
     * DFS后序遍历（「道法自然」的题解），取的结果是「从根节点到叶子节点的所有路径」，即非叶子节点
     *
     * @see #dfsPreOrder
     */
    public static void dfsPostOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<>(subset);

        dfsPostOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        dfsPostOrder(nums, i + 1, subset, res);
        // 这里
        res.add(subset);
    }


    /**
     * 回溯，按「灵茶山艾府」的说法，是从答案的视角（选哪个元素）
     *
     * @see <a href="https://leetcode.cn/problems/subsets/solutions/2059409/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-8tkl/">主站78题「灵茶山艾府」题解</a>
     * @see <a href="https://www.hello-algo.com/chapter_backtracking/backtracking_algorithm/">Krahets的《Hello算法》的回溯算法</a>
     */
    public static void backtrack(int[] nums, int start, ArrayList<Integer> subset, List<List<Integer>> res) {
        // System.out.println("[DEBUG]backtrack entering..." + "start = " + start + ", subset = " + subset);
        res.add(new ArrayList<>(subset));
        // if (start == nums.length) return;  // 此句可省略
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }

}
