package com.example.demo.global.result;

import com.auth0.jwt.JWT;
import com.example.demo.global.config.GlobalException;
import com.example.demo.global.config.ResponseEnum;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.global.result
 * @date 2023/4/11 10:05
 * @description TODO
 */
public class JwtInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否通过有PassToken注解
        if (method.isAnnotationPresent(PassToken.class)) {
            //如果有则跳过认证检查
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        if (StringUtils.isEmpty(token)) {
            throw  new GlobalException(ResponseEnum.TOKEN_EX.getCode(),ResponseEnum.TOKEN_EX.getResultMessage());
        }
        // 获取token中的userId
        String userId;

        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (GlobalException j) {
            throw new GlobalException(ResponseEnum.TOKEN_EX.getCode(), ResponseEnum.TOKEN_EX.getResultMessage());

        }








        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}