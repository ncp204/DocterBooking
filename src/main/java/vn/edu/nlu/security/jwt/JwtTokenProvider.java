package vn.edu.nlu.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    private final String JWT_SECRET = "ncphuc";

    //Thời gian có hiệu lực của chuỗi jwt, 86400 = 1 ngày
    private final int JWT_EXPIRATION = 86400;

    private final int JWT_EXPIRATION_2M = 120;

    // Tạo ra jwt từ thông tin user với thời gian 2 phút
    public String generateToken(String email) {
        return Jwts.builder().setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + JWT_EXPIRATION * 1000))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    //  Kiểm tra token có hợp lệ hay không
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Token không hợp lệ");
        } catch (ExpiredJwtException ex) {
            log.error("Token đã hết hiệu lực");
        } catch (UnsupportedJwtException ex) {
            log.error("Token không được hỗ trợ");
        } catch (IllegalArgumentException ex) {
            log.error("Chuỗi yêu cầu trống");
        }
        return false;
    }

    // Lấy thông tin user từ jwt
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

}

