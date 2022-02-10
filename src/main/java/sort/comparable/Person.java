package sort.comparable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangbo
 * @since 2021/11/18 14:21
 */
@Data
@AllArgsConstructor
public class Person implements Comparable {

    private String name;
    private int age;
    private double weight;

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;

        // 按姓名升序
        // return this.name.compareTo(p.getName());

        // 按年龄升序
        // return this.age - p.getAge();

        // 先按年龄升序，再按姓名降序
        int num = this.age - p.getAge();
        int num2 = num == 0 ? -this.name.compareTo(p.getName()) : num;
        return num2;
    }
}


