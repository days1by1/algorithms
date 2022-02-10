package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangbo
 * @since 2021/11/15 22:12
 */
public class SortTest2 {

    List<Dog> list = new ArrayList<Dog>() {
        {
            add(new Dog(5, "DogA", "001"));
            add(new Dog(5, "DogB", "002"));
            add(new Dog(5, "DogC", "003"));
            add(new Dog(9, "DogA", "004"));
            add(new Dog(35, "DogF", "005"));
            add(new Dog(74, "Dogg", "006"));
        }
    };

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static
    class Dog { //内部类
        public int age;
        public String name;
        public String num;
    }
}
