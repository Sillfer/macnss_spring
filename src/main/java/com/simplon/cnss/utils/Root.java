package com.simplon.cnss.utils;

import com.simplon.cnss.Config.BaseUrl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class Root implements Filter {

    private String baseUrl;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.baseUrl = BaseUrl.BASE_URL;
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        System.out.println("session inside filter: "+session);

        String requestedUrl = httpRequest.getRequestURL().toString();
        String loginUrl = this.baseUrl+"users/login";

        if(session.getAttribute("person") == null && !loginUrl.equals(requestedUrl)){
            httpResponse.sendRedirect(BaseUrl.BASE_URL+"users/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
