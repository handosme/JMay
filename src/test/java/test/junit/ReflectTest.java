package test.junit;

import org.ihansen.jsmta.dao.impl.CommonDAOImpl;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by wus on 2017/6/12.
 */
public class ReflectTest {

    @Test
    public void test1(){
        Method[] methods = CommonDAOImpl.class.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
