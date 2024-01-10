package de.dm.infrastructure.metrics.testfixtures;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.lang.reflect.InvocationTargetException;

public class SetupUtil {

    private static <T> T createProxy(Advisor advisor, Object noProxy) {
        AspectJProxyFactory factory = new AspectJProxyFactory(noProxy);
        factory.addAdvisor(advisor);
        return factory.getProxy();
    }

    public static <T> T setUpAdvisedClass(Class<T> clazz, Advisor advisor) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        T noProxy = clazz.getDeclaredConstructor().newInstance();
        return createProxy(advisor, noProxy);
    }
}
