package org.example.scheduler.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;

import static org.example.scheduler.filter.LoginFilter.isWhiteList;

@Slf4j
public class UserAuthorizationFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String requestURL = httpRequest.getRequestURI();

        if(!isWhiteList(requestURL)) {
            HttpSession session = httpRequest.getSession(false);
            Long loginUserId = (Long) session.getAttribute("login-userId");

            String[] split = requestURL.split("/");
            String userIdStr = split[split.length-1];
            Long userId = Long.parseLong(userIdStr);

            if (!loginUserId.equals(userId)) throw new AuthenticationException("다른 사용자의 리소스입니다.");

        }

        filterChain.doFilter(httpRequest, httpResponse);
    }
}
