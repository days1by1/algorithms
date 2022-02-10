package javab1210327;

public class OverrideDemoImpl extends OverrideDemo {

    @Override
    public void print() {
        System.out.println("print()实现");
    }

    public static void main(String[] args) {
        new OverrideDemoImpl().print();
    }
}

abstract class Father {
    public abstract void print();
}

class Child extends Father {
    // @Override
    public void print() {
        System.out.println("print()实现");
    }
}

