package test;

import java.util.*;
import java.util.stream.Collectors;

public class Test0816 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        // list.add("bbb");
        list.add("ccc");
        System.out.println(list);
        // Iterator<String> iterator = list.iterator();
        // while (iterator.hasNext()) {
        //     String s = iterator.next();
        //     if ("bbb".equals(s)) {
        //         iterator.remove();
        //     }
        // }
        // System.out.println(list);


        for (String s : list) {
            if ("bbb".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list);


        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        System.out.println(set);

        Set<String> set2 = new HashSet<>();
        set2.add("aaa");
        set2.add("bbb");

        // Set<String> set_copy = set.stream().collect(Collectors.toSet());
        HashSet<String> set_copy = new HashSet<>(set);
        // set.removeAll(set2);
        set.retainAll(set2);
        System.out.println(set);
        System.out.println(set_copy);
    }
}
