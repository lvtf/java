package dynamic_proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ClientStart {
    public static void main(String[] args) {

        Class pClass = P.class;
        Client client = new Client();
        P proxy = (P)client.getProxy(pClass);
        proxy.eat();


        P p = (P)Proxy.newProxyInstance(Person.class.getClassLoader(), Person.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(new Person(),args);
            }
        });
        p.sleep("xiaoming");
    }


}
