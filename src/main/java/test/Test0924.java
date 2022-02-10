package test;

import bean.Person;
import org.junit.Test;

import java.util.*;

/**
 * 测试Map集合对键的排序
 */
public class Test0924 {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "关羽");
        map.put(1, "刘备");
        map.put(3, "张飞");
        System.out.println(map);

        // 2021-09-29
        List<Person> persons = Arrays.asList(
                new Person("刘备", 27),
                new Person("关羽", 26),
                new Person("张飞", 25)
        );
        System.out.println(persons);

        ArrayList<Person> persons2 = new ArrayList<Person>() {
            {
                add(new Person("刘备", 27));
                add(new Person("关羽", 26));
                add(new Person("张飞", 25));
            }
        };
        System.out.println(persons2);
    }

    @Test
    public void test01() {
        // Arrays.sort提供Comparator进行排序
        Person[] persons = new Person[]{
                new Person("Larry", 18),
                new Person("David", 30),
                new Person("James", 20),
                new Person("Harry", 18)};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(persons));

        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        Arrays.sort(persons, (o1, o2) -> o1.getAge() - o2.getAge());

        Arrays.sort(persons, Comparator.comparingInt(Person::getAge));

        // Arrays.sort(persons, Comparator.comparingInt(Person::getAge));

        System.out.println("排序后：");
        System.out.println(Arrays.toString(persons));
    }
}
