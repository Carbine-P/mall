package com.springboot.mall.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController//表示这是一个控制器;它会将每个方法的返回值都直接转换为 json 数据格式
@ControllerAdvice//本质上是一个Component;
/*属于aop思想的一种实现，你告诉我拦截规则，我帮你把他们拦下来，
具体的更细致的拦截筛选和拦截之后的处理，
需要通过@ExceptionHandler、@InitBinder 或 @ModelAttribute这三个注解以及被其注解的方法来自定义。*/
public class GloabalExceptionHandler {
    @ExceptionHandler(value = Exception.class)//与@ControllerAdvice 配合实现全局异常处理
    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        e.printStackTrace();
        Class constraintViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
        if (null != e.getCause() && constraintViolationException == e.getCause().getClass()) {
            return "违反了约束，多半是外键约束";
        }
        return e.getMessage();
    }
}
