//import java.io.UnsupportedEncodingException;
//import java.util.Base64;
//import java.util.Date;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//public class JWTTest {
//    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
//        String token = Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT")
//                .claim("userId", "young")
//                .setExpiration(new Date(System.currentTimeMillis()+3000))
//                .signWith(SignatureAlgorithm.HS256, "EGGMONEY".getBytes("UTF-8"))
//                .compact();
//
//        System.out.println(token);
//
//        System.out.println(new String(Base64.getDecoder().decode(token.split("\\.")[1])));
//
//        // 강제로 4초 sleep
//        // Thread.sleep(4000);
//        // 유효하지 않은 키로 인식돼서 error 발생
//
//        // 유효성 검사
//        Jws<Claims> claims = Jwts.parser().setSigningKey("EGGMONEY".getBytes("UTF-8")).parseClaimsJws(token);
//
//        System.out.println(claims);
//    }
//}
