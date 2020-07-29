package dynamic_proxy2;

public class Person implements P {
    @Override
    public void sleep(String name) {
        System.out.println(name + "在睡觉");
    }

    @Override
    public void eat() {
        System.out.println("在吃饭");
    }
}
