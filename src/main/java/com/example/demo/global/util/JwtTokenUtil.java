package com.example.demo.global.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;


import java.util.Calendar;

/**
 * @author muyongsong
 * @version 1.0
 * @package com.example.demo.global.util
 * @date 2023/4/11 09:40
 * @description TODO
 */
@Component
public class JwtTokenUtil {

    private final  String SECRET_KEY = "secret";

    /**
     * 生成token
     * @param userId
     * @return
     */
    public static String getToken(String userId,String sign) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 90);
        return JWT.create()
                //签收者
                .withAudience(userId)
                //主题
                .withSubject("token")
                //2小时候token过期.
                .withExpiresAt(calendar.getTime())
                //以password作为token的密钥
                .sign(Algorithm.HMAC256(sign));
    }

    // 验证 token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token); // 使用相同的 secret 进行签名验证
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}