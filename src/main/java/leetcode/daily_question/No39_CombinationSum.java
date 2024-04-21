package leetcode.daily_question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 难度：中等
 *
 * @author wangbo
 * @created 2024年04月21日 23:20
 */
public class No39_CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {3, 4, 5};
        int target = 9;
        System.out.println(combinationSum(candidates, target));

        int[] candidates2 = {2, 3, 6, 7};
        int target2 = 7;
        System.out.println(combinationSum(candidates2, target2));

        int[] candidates3 = {2, 3, 5};
        int target3 = 8;
        System.out.println(combinationSum(candidates3, target3));

        int[] candidates4 = {2};
        int target4 = 1;
        System.out.println(combinationSum(candidates4, target4));
    }

    // Krahets题解：回溯
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 对 candidates 进行排序
        List<Integer> state = new ArrayList<>(); // 状态（子集）
        int start = 0; // 遍历起始点
        List<List<Integer>> res = new ArrayList<>(); // 结果列表（子集列表）
        backtrack(state, target, candidates, start, res);
        return res;
    }

    public static void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        for (int i = start; i < choices.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target < choices[i]) {
                break;
            }
            // 尝试：做出选择，更新 target, start
            state.add(choices[i]);
            // 进行下一轮选择
            backtrack(state, target - choices[i], choices, i, res);
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }

}
