package aop;

import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import service.HelloService;

import java.lang.reflect.Method;

/**
 * ● @author: YiHui
 * ● @date: Created in 18:16  2023/9/24
 * ● @Description: description
 */
public class PointcutExpressionTest {
    @Test
    public void testPointcutExpression() throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* service.HelloService.*(..))");
        Class<HelloService> clazz = HelloService.class;
        Method method = clazz.getDeclaredMethod("hello");

        System.out.println("切点表达式匹配结果-类匹配："+pointcut.matches(clazz));
        System.out.println("切点表达式匹配结果-方法匹配："+pointcut.matches(method, clazz));
    }
}
