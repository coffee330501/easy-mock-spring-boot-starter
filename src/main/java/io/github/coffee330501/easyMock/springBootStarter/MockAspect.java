package io.github.coffee330501.easyMock.springBootStarter;

import io.github.coffee330501.easyMock.Mock;
import io.github.coffee330501.easyMock.MockManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class MockAspect {
    @Around("@annotation(io.github.coffee330501.easyMock.Mock)")
    public Object aroundMock(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!MockManager.isGlobalUseMock()) return joinPoint.proceed(joinPoint.getArgs());

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Mock mockAnnotation = method.getAnnotation(Mock.class);

        String value = mockAnnotation.value();
        if (value == null || value.length() == 0) value = signature.getReturnType().getName();
        return MockManager.mock(value, joinPoint.getArgs());
    }
}
