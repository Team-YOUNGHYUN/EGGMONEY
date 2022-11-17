package com.eggmoney.backend.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.board.util.JwtUtil;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private static final String HEADER_AUTH = "access-token";


    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 아래는 검색해서 찾아보기
        // OPTIONS라는 이름으로 오면 그냥 통과
        if(request.getMethod().contentEquals("OPTIONS")) return true;

        final String token = request.getHeader(HEADER_AUTH);

        if(token != null) { // 일단은 토큰이 존재하는지 확인
            jwtUtil.valid(token);
            return true;
        }

        throw new Exception("유효하지 않은 접근이다.");
    }

}
