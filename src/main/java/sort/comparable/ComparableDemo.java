package sort.comparable;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangbo
 * @since 2021/11/18 14:22
 */
public class ComparableDemo {

    Person[] array = new Person[]{
            new Person("caocao", 30, 70.2),
            new Person("liubei", 30, 62.5),
            new Person("zhangfei", 25, 85),
            new Person("guanyu", 28, 88.8),
            new Person("sunquan", 9, 65.8),
            new Person("zhugeliang", 29, 72.5)
    };
    List<Person> list = Arrays.asList(array);

    @Test
    public void test1() {
        // Arrays.sort(array);
        // for(Person p : list){
        //     System.out.println(p);
        // }

        // Collections.sort(list);
        // 当需要倒序时，可以使用Collections.reverse()
        // Collections.reverse(list);

        // 当元素具有比较性时，可以使用Comparator.naturalOrder()、Comparator.reverseOrder()
        // list.sort(Comparator.naturalOrder());
        // list.sort(Comparator.reverseOrder());


        list.forEach(System.out::println);
    }
}
