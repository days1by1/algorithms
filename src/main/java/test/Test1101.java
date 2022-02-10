package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println(sc.nextInt());
////        System.out.println(sc.next());
////        System.out.println(sc.next());
//        --System.//out.//println//(sc.nextLine());

//        int n = Integer.parseInt(sc.nextIn)
//        int k = sc.nextInt();
//        int m = sc.nextInt();
//
//        String[] words = new String[n];
//        for(int i=0; i<n; i++) {
//            words[i] = sc.next();
//        }
//
//        String[][] groups = new String[k][];
//        for(int i=0; i<k; i++) {
//            groups[i] = sc.nextLine().split(" ");
//        }
//
//
//
//        // 定义数组存储每个单词的成本和是否有同义词
//        int[][] costAndGroup = new int[2][n];
//        for(int i=0; i<n; i++){
//            System.out.println(costAndGroup[0][i]);
//        }
//
//        for(int i=0; i<k; i++) {
//            for(int j=0; j<groups[i].length; j++) {
//                System.out.print(groups[i][j] + " ");
//                System.out.println();
//            }
//        }

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
            if (!groupsStr[i][0].equals("1")) {
                for (int j = 1; j < groupsStr[i].length; j++) {
                    groups[Integer.parseInt(groupsStr[i][j]) - 1] = i;
                }
            }
//            System.out.println(Arrays.toString(groupsStr[i]));
        }

        int leastCost = 0;
        Map<String ,Integer> wordsMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            wordsMap.put(words[i],i);
        }
        for (int i = 0; i <m; i++) {
            if(groups[wordsMap.get(message[i])]==0){
                leastCost += costs[wordsMap.get(message[i])];
            }else{
                int group = groups[wordsMap.get(message[i])];
                int min = costs[wordsMap.get(message[i])];
                for(int j=0; j<n; j++) {
                    if(groups[j]==group){
                        min=costs[j]<min? costs[j]: min;
                    }
                }
                leastCost += min;
                min=0;
            }
        }
        System.out.println(leastCost);

//        System.out.println(Arrays.toString(words));
//        System.out.println(Arrays.toString(costs));;
//        System.out.println(Arrays.toString(groups));;

//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j < groups[i].length; j++) {
//                System.out.print(groups[i][j] + " ");
//            }
//            System.out.println();
//        }


    }

    public static void leastCost() {

    }
}
