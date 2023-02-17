package com.zzz.aop.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Author zjc
 * @Date 2023/2/17 11:41
 */

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.zzz.aop.common.LogAnnotation)")
    public void logPointCut() {

    }

    @Before("logPointCut()")
    public void before() {
        log.info("before...通知");
    }

    @After("logPointCut()")
    public void after() {
        log.info("after...通知");
    }

    @AfterReturning("logPointCut()")
    public void afterReturning() {
        log.info("afterReturning...通知");
    }

    @AfterThrowing(pointcut  = "logPointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("AfterThrowing................通知");
    }
    /**
     * 可控制目标函数是否执行
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around................通知");
        log.info("进入Around通知....");
        record(joinPoint);

        /**
         * 进行业务操作
         */
        Object r = joinPoint.proceed();

        return r;
    }

    private void record(ProceedingJoinPoint joinPoint) {
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

//        String token = httpServletRequest.getHeader("token");
        //获取注解信息
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        String module = logAnnotation.module();
        String operator = logAnnotation.operator();

        String className = joinPoint.getTarget().getClass().getName();
        String name = signature.getName();

        //获取切入点方法参数
        Object[] objects = joinPoint.getArgs();
        String[] paramNames = signature.getParameterNames();
    }
}
