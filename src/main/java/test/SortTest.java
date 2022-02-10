package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * Comparator比较器：https://www.cnblogs.com/MrYuChen-Blog/p/14012428.html
 */
public class SortTest {

    @Data
    @AllArgsConstructor
    class Dog implements Comparable { //内部类
        private String name;
        private int age;
        private String num;
        private double weight;

        @Override
        public int compareTo(Object o) {
            return this.age - ((Dog) o).getAge();
        }
    }

    List<Dog> list = new ArrayList<Dog>() {
        {
            add(new Dog("DogA", 5, "001", 10.1));
            add(new Dog("DogA", 9, "004", 12.5));
            add(new Dog("DogB", 9, "002", 5.5));
            add(new Dog("DogC", 5,"003", 5.0));
            add(new Dog( "Dogg", 74,"006", 7.8));
            add(new Dog( "DogF", 35,"005", 8.7));
        }
    };

    /**
     * 单一条件排序
     */
    @Test
    public void test1() {
        // 按照年龄排序
        Collections.sort(list, new Comparator<Dog>() {
            // 实现compare(T d1, T d2) 方法，返回正数、零和负数分别代表大于、等于和小于
            @Override
            public int compare(Dog d1, Dog d2) {
                // 按照年龄升序
                // return d1.getAge() - d2.getAge();

                // 按照年龄升序
                // return d2.getAge() - d1.getAge();

                // 把年龄转换成字符串，用String的compareTo()方法排序
                return String.valueOf(d1.getAge()).compareTo(String.valueOf(d2.getAge()));
            }
        });
        // 使用Lambda表达式简化
        // Collections.sort(list, (d1, d2) -> (d1.getAge() - d2.getAge()));
        // 使用方法引用进一步简化
        // Collections.sort(list, Comparator.comparingInt(Dog::getAge));
        // 后者减去前者（按照年龄降序）时不能使用方法引用,
        // Collections.sort(list, (d1, d2) -> (d2.getAge() - d1.getAge()));
        // 但可以采用先升序再倒序的方式（使用Collections.reverse()，类似于StringBuffer.reverse()）
        // Collections.sort(list, Comparator.comparingInt(Dog::getAge));
        // Collections.reverse(list);
        // 按名字字母顺序排序（内部类的私有属性可以直接访问）
        // Collections.sort(list, (d1, d2) -> d1.name.compareTo(d2.name));
        // Collections.sort(list, Comparator.comparing(d -> d.name));
        // 还可以直接使用List.sort()方法
        // list.sort(Comparator.comparingInt(Dog::getAge));
        // list.sort(Comparator.comparingInt(Dog::getAge).reversed());
        // list.sort(Comparator.comparing(Dog::getAge));
        // list.sort(Comparator.comparing(Dog::getAge, Comparator.reverseOrder()));
        // list.sort(Comparator.comparing(Dog::getWeight));
        // list.sort(Comparator.naturalOrder());
        // list.sort(Comparator.reverseOrder());


        // 元素具有比较性
        // Collections.sort(list);
        // list.sort(Comparator.naturalOrder());

        for (Dog dog : list) {
            System.out.println(dog);
        }


    }

    /**
     * 使用Lambda表达式优化比较器代码（单一条件排序）
     */
    @Test
    public void test03() {
        // 按照年龄升序
        Collections.sort(list, (d1, d2) -> (d1.getAge() - d2.getAge()));
        // Collections.sort(list, Comparator.comparingInt(Dog::getAge));
        // for (Dog dog : list) {
        //     System.out.println(dog);
        // }
        //
        // Collections.reverse(list);
        // list.forEach(System.out::println);

        /*int compare = Integer.compare(10, 20);
        System.out.println(compare);

        int compare1 = Long.compare(-10L, -20L);
        System.out.println(compare1);

        int compare2 = Double.compare(3.14, 2.71);
        System.out.println(compare2);*/

        // System.out.println(new StringBuffer("abcde").reverse());

        // Optional<Dog> max = list.stream().max(Comparator.comparing(Dog::getAge));
        // System.out.println(max.get());


        /*List<String> strings = Arrays.asList("def", "abc", "ABC", "hel", "world");
        strings.sort(Comparator.comparingInt(String::length).reversed() //（1）
                        // .thenComparing(String::compareToIgnoreCase) // （2）
                        .thenComparing(String::compareTo)
                        .reversed()
                // .thenComparing(Comparator.reverseOrder()) // （3）这个比较器不会被应用 因为比较器（2）已经把结果比较出来了，并且没有相等的结果，这里不会再应用（3）比较器
        );

        System.out.println(strings); // 输出[world, abc, def, hel]
*/
        list.forEach(Persons -> System.out.println("Persons age"+Persons.age));


    }

    /**
     * 多条件排序
     */
    @Test
    public void test3() {
        Collections.sort(list, new Comparator<Dog>() {
            @Override
            public int compare(Dog s1, Dog s2) {
                // 首先按年龄升序排序
                int num = s1.getAge() - s2.getAge();
                // if (num == 0) {
                //     // 如果年龄相同，则按编号降序排序
                //     num = s2.getNum().compareTo(s1.getNum());
                // }
                // 使用Optional（orElse()与orElseGet()的细微区别——当Optional有值时，orElse()会执行，orElseGet()则不会）
                num = Optional.ofNullable(num == 0 ? null : num).orElse(s2.getNum().compareTo(s1.getNum()));
                // num = Optional.ofNullable(num == 0 ? null : num).orElseGet(() -> s2.getNum().compareTo(s1.getNum()));
                return num;
            }
        });
        // 此处Lambda表达式相比增强for循环更简洁
        list.forEach(System.out::println);
    }

    /*@Test
    public void test2() {
        // 按照名字排序
        // Collator comparator = Collator.getInstance(Locale.CANADA);
        Collections.sort(list, new Comparator<Dog>() {
            @Override
            public int compare(Dog d1, Dog d2) {
                // 按名字字母顺序排序
                return d1.name.compareTo(d2.name);
                // return comparator.compare(d1.getName(), d2.getName());
            }
        });
        for (Dog dog : list) {
            System.out.println(dog);
        }
    }*/

    /**
     * 多条件排序（使用Lambda表达式）
     */
    /*@Test
    public void test5() {
        Collections.sort(list, (s1, s2) -> {
            // 首先按年龄升序排序
            int num = s1.getAge() - s2.getAge();
            if (num == 0) {
                // 如果年龄相同，则按编号降序排序
                num = Optional.ofNullable(num == 0 ? null : num).orElse(s2.getNum().compareTo(s1.getNum()));
                // num = s2.getNum().compareTo(s1.getNum());
            }
            return num;
        });
        // 此处Lambda表达式相比增强for循环更简洁
        list.forEach(System.out::println);
    }*/
    @Test
    public void test00() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("北京");
    }

    @Test
    public void test01() {
        // Arrays.so

        int[][] nums = new int[][]{{1, 3}, {1, 2}, {5, 1}, {4, 5}, {3, 3}};
        //方法一
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 当第一维相等时比较第二维的
                // if (a[0] == b[0]) {
                //     return a[1] - b[1];
                // } else {
                //     return a[0] - b[0];
                // }
                return a[0] - b[0];
            }
        });

        // 方法二，使用 lambda 表达式
        // Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Arrays.sort(nums, );
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
        // 结果 ： [1, 2][1, 3][3, 3][4, 5][5, 1]
    }

}