package com.example.ch08.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BeerRequestFilter implements Filter {
    private FilterConfig fc;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq= (HttpServletRequest) request;
        String name = httpReq.getRemoteUser();

        if(name != null) {
            fc.getServletContext().log("User " +name+ " is updating");
        }

        chain.doFilter(request, response); // 다음에 실행될 필터 또는 서블릿 호출
    }

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void destroy() {
        // 마무리 코딩
    }
}
