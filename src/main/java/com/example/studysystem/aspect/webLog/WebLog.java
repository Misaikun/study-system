package com.example.studysystem.aspect.webLog;

import java.lang.annotation.*;

/**
 * @author Misaikun
 * @ClassName WebLog
 * @description
 * @date 2020/2/14 20:46
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public  @interface WebLog {
    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "";

}
