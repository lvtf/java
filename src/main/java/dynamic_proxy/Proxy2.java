package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy2 {
    public static void main(String[] args) {
        ProxyObject proxy = new ProxyObject();
        Class pClass = P.class;
        P p = (Person) proxy.getProxy(pClass);
        p.eat();
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


class ProxyObject {
    Object object = new Object();

    public Object getProxy(Class pClass) {
        return Proxy.newProxyInstance(pClass.getClassLoader(), new Class<?>[]{pClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(object, args);
            }
        });

    }
}