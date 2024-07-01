package com.example.demo.base.unit;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数：线程池创建的时候初始化的线程数
        executor.setCorePoolSize(5);
        // 最大线程数：线程池最大的线程数，只有缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(20);
        // 等待队列：用来缓冲执行任务的队列
        executor.setQueueCapacity(300);
        // 最大空闲时间：超过核心线程之外的线程到达200秒后会被销毁
        executor.setKeepAliveSeconds(200);
        // 拒绝策略：超过线程容量,拒绝策略设置（由调用的线程执行）
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 线程名称前缀
        executor.setThreadNamePrefix("Async Task-");
        // 初始化线程
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
