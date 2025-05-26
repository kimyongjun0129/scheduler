package org.example.scheduler.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/api/users", "/api/auth/*"};

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURL = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        // WHITE LIST에 포함되지 않은 경우 실행
        if(!isWhiteList(requestURL)) {
            HttpSession session = httpRequest.getSession(false);

            if(session == null || session.getAttribute("login-userId") == null) {
                throw new AuthenticationException("로그인을 먼저 시도해주세요.");
            }

            log.info("로그인에 성공했습니다.");
        }

        filterChain.doFilter(httpRequest, httpResponse);
    }

    public static boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
