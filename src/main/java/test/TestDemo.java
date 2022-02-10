package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nums = sc.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);
        int m = Integer.parseInt(nums[2]);

        String[] words = sc.nextLine().split(" ");
        String[] costsStr = sc.nextLine().split(" ");
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(costsStr[i]);
        }

        String[][] groupsStr = new String[k][];
        for (int i = 0; i < k; i++) {
            groupsStr[i] = sc.nextLine().split(" ");
        }
        String[] message = sc.nextLine().split(" ");

        int[] groups = new int[n];
        for (int i = 0; i < k; i++) {
            if (groupsStr[i].length>2) {
                for (int j = 1; j < groupsStr[i].length; j++) {
                    groups[Integer.parseInt(groupsStr[i][j]) - 1] = i;
                }
            }
        }

        long leastCost = 0;
        Map<String, Integer> wordsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            wordsMap.put(words[i], i);
        }
        for (int i = 0; i < m; i++) {
            if (groups[wordsMap.get(message[i])] == 0) {
                leastCost += costs[wordsMap.get(message[i])];
            } else {
                int group = groups[wordsMap.get(message[i])];
                int min = costs[wordsMap.get(message[i])];
                for (int j = 0; j < n; j++) {
                    if (groups[j] == group) {
//                        min = costs[j] < min ? costs[j] : min;
                        min = Math.min(costs[j],min);
                    }
                }
                leastCost += min;
            }
        }

        System.out.println(leastCost);
    }
}
