package com.example.musicproject.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
//记录方法名、参数、执行时间、是否成功等日志信息
public class logAspect {
    @Around("@annotation(com.example.musicproject.annotation.LogOperation)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        long start =System.currentTimeMillis();

        MethodSignature signature=(MethodSignature)joinPoint.getSignature();

        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        Object[] args = joinPoint.getArgs();

        log.info("开始执行方法：{}", methodName);
        log.info("参数：{}", Arrays.toString(args));

        Object result;
        try {
            result = joinPoint.proceed(); // 执行目标方法
            long duration = System.currentTimeMillis() - start;
            log.info("方法执行成功，耗时：{} ms", duration);
            log.info("返回值：{}", result);

        }catch (Throwable ex){
            log.error("方法执行异常：{}", ex.getMessage(), ex);
            throw ex;
        }
        return result;

    }


}
