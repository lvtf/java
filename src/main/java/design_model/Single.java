package design_model;

public class Single {

    private Single() {
        System.out.println("构造方法初始化");
    }

    static {
        System.out.println("static");
    }

    private static Single single;

    public static synchronized Single getSingle() {
        if (single == null) {
            synchronized (Single.class) {
                single = new Single();
            }
        }
        return single;
    }
}