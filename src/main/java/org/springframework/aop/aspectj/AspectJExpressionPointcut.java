package org.springframework.aop.aspectj;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * ● @author: YiHui
 * ● @date: Created in 17:33  2023/9/24
 * ● @Description: 这是一个自定义的 AspectJ 表达式切点，用于在 Spring AOP 中匹配切点表达式。
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {

    // 支持的切点原语集合
    private static final Set<PointcutPrimitive> SUPPORTED_PRIMITIVES = new HashSet<>();

    static {
        // 添加支持的切点原语。在此示例中，我们仅支持 EXECUTION 原语，您可以根据需要添加更多。
        SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }

    // 切点表达式对象，用于解析和匹配切点
    private final PointcutExpression pointcutExpression;

    /**
     * 构造函数，用给定的表达式创建 AspectJ 表达式切点。
     *
     * @param expression 切点表达式，用于定义匹配的切点
     */
    public AspectJExpressionPointcut(String expression) {
        // 创建一个 PointcutParser 实例，用于解析切点表达式
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(
            SUPPORTED_PRIMITIVES, this.getClass().getClassLoader());

        // 解析给定的切点表达式并将其分配给成员变量 pointcutExpression
        pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }

    /**
     * 检查给定的类是否符合切点表达式的条件。
     *
     * @param clazz 要检查的类
     * @return 如果类匹配切点表达式，则返回 true，否则返回 false
     */
    @Override
    public boolean matches(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    /**
     * 检查给定的方法是否符合切点表达式的条件。
     *
     * @param method      要检查的方法
     * @param targetClass 方法所属的目标类
     * @return 如果方法匹配切点表达式，则返回 true，否则返回 false
     */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        // 使用切点表达式检查方法执行是否匹配
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    /**
     * 获取用于类筛选的 ClassFilter 实例。
     *
     * @return ClassFilter 实例，用于过滤匹配的类
     */
    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    /**
     * 获取用于方法匹配的 MethodMatcher 实例。
     *
     * @return MethodMatcher 实例，用于匹配符合切点表达式的方法
     */
    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
