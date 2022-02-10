package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：有两个集合，现在要对集合2进行操作。集合1有而集合2没有的元素，则添加到集合2；
 *      集合1没有而集合2有的元素，要从集合2中删去。
 *
 * @author wangbo
 * @since 2021/11/26 22:15
 */
public class Test1126 {
    public static void main(String[] args) {
        // List<String> oldList = Arrays.asList("1", "2", "3", "5");
        // List<String> newList = Arrays.asList("1", "3", "5", "7");
        List<String> oldList = new ArrayList<String>() {
            {
                add("1");
                add("2");
                add("3");
                add("5");
            }
        };
        List<String> newList = new ArrayList<String>() {
            {
                add("1");
                add("3");
                add("5");
                add("7");
            }
        };

        // 方法1：removeAll()
        /*List<String> toBeDeleted = new ArrayList<>(oldList);
        toBeDeleted.removeAll(newList);
        oldList.removeAll(toBeDeleted);

        newList.removeAll(oldList);
        oldList.addAll(newList);
        System.out.println(oldList);*/

        // 方法2：遍历 + 增删方法
        for (String s : newList) {
            if (!oldList.contains(s)) {
                oldList.add(s);
            }
        }
        // 避免对oldList作遍历和修改时出现并发修改异常，复制到oldList2
        List<String> oldList2 = new ArrayList<>(oldList);
        for (String s : oldList2) {
            if (!newList.contains(s)) {
                oldList.remove(s);
            }
        }
        System.out.println(oldList);
    }
}
