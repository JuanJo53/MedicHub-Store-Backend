package bo.ucb.edu.medichub.util.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static String KEY = "m3d1chub";

    public String generateToken(UserDetails user){
        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *10))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

}
