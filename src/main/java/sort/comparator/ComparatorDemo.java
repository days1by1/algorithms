package sort.comparator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangbo
 * @since 2021/11/18 15:28
 */
public class ComparatorDemo {

    Person[] array = new Person[]{
            new Person("caocao", 30, 70.2),
            new Person("liubei", 30, 62.5),
            new Person("zhangfei", 25, 85),
            new Person("guanyu", 28, 88.8),
            new Person("sunquan", 9, 65.8),
            // null,
            new Person("zhugeliang", 29, 72.5)
    };
    List<Person> list = Arrays.asList(array);

    @Test
    public void test1() {
        // 按照姓名升序
        // Collections.sort(list, new Comparator<Person>() {
        //     @Override
        //     public int compare(Person o1, Person o2) {
        //         return o1.getName().compareTo(o2.getName());
        //     }
        // });

        // 按照年龄升序，使用Lambda表达式简化
        // Collections.sort(list, (o1, o2) -> o1.getAge() - o2.getAge());
        // 使用方法引用进一步简化
        // Collections.sort(list, Comparator.comparingInt(Person::getAge));
        // 后者减去前者（按照年龄降序）时不能使用方法引用,
        // Collections.sort(list, (o1, o2) -> o2.getAge() - o1.getAge());
        // 但可以采用先升序再倒序的方式（使用Collections.reverse()，类似于StringBuffer.reverse()）
        // Collections.sort(list, Comparator.comparingInt(Person::getAge));
        // Collections.reverse(list);

        // 把年龄转换成字符串来升序
        // Collections.sort(list, (Comparator.comparing(o -> String.valueOf(o.getAge()))));

        // 先按照年龄升序，再按照姓名降序
        // Collections.sort(list, ((o1, o2) -> {
        //     return o1.getAge() - o2.getAge() == 0 ? o2.getName().compareTo(o1.getName()) : o1.getAge() - o2.getAge();
        // }));

        // 还可以直接使用List.sort()方法
        // list.sort(Comparator.comparingInt(Person::getAge));
        // list.sort(Comparator.comparingInt(Person::getAge).reversed());
        //
        // list.sort(Comparator.comparing(Person::getAge));
        // list.sort(Comparator.comparing(Person::getAge, Comparator.reverseOrder()));
        //
        // list.sort(Comparator.comparing(Person::getWeight));
        // list.sort(Comparator.comparingDouble(Person::getWeight));
        // list.sort(Comparator.naturalOrder());
        // list.sort(Comparator.reverseOrder());


        // 使用thenComparing()实现多条件排序：先按照年龄升序，再按照姓名降序
        // list.sort(Comparator.comparing(Person::getAge).thenComparing(Comparator.comparing(Person::getName)
        // .reversed()));

        // 当集合中存在null元素时，可以使用Comparator.nullsFirst()、Comparator.nullsLast
        // list.sort(Comparator.nullsFirst(Comparator.comparing(Person::getAge)).thenComparing(Comparator.comparing
        // (Person::getName).reversed()));
        // list.sort(Comparator.nullsLast(Comparator.comparing(Person::getAge)).thenComparing(Comparator.comparing(Person::getName).reversed()));

        System.out.println(list.stream().max(Comparator.comparingInt(Person::getAge)));

        // list.forEach(System.out::println);
    }


    @Test
    public void test2() {
        int[][] nums = new int[][]{{1, 3}, {1, 2}, {4, 5}, {3, 7}};
        // 先按第一列元素升序，再按第二列元素升序
        // Arrays.sort(nums, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] a, int[] b) {
        //         if (a[0] == b[0]) {
        //             return a[1] - b[1];
        //         } else {
        //             return a[0] - b[0];
        //         }
        //     }
        // });

        // 使用Lambda表达式
        // Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 按第二列元素降序
        Arrays.sort(nums, (a, b) -> b[1] - a[1]);

        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }

    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer max = list.stream().max((a, b) -> {
            if (a > b) {
                return 1;
            } else return -1;
        }).get();

        System.out.println(max);
    }
}
