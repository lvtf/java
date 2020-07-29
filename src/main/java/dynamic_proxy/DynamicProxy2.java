package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy2 implements InvocationHandler {
    Object object;

    public DynamicProxy2(P person) {
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(object,args);
        return null;
    }

    public static void main(String[] args) {
        DynamicProxy2 proxy = new DynamicProxy2(new Person());
        P o = (P)Proxy.newProxyInstance(P.class.getClassLoader(), new Class<?>[]{P.class}, proxy);
        o.sleep("xiaoming");
        o.eat();
    }


    interface P {
        void sleep(String name);

        void eat();
    }

    static class Person implements P {
        @Override
        public void sleep(String name) {
            System.out.println(name + "在睡觉");
        }

        @Override
        public void eat() {
            System.out.println("在吃饭");
        }
    }
}

