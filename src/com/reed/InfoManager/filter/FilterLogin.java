package com.reed.InfoManager.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FilterLogin implements Filter {
    String noAccess = null;
    String access = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        noAccess = filterConfig.getInitParameter("noAccess");
        access = filterConfig.getInitParameter("Access");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();

        String[] noAccessStr = noAccess.split(",");
        String[] accessStr = access.split(",");
        String path = req.getServletPath().substring(1);    //获取"/"后面的内容

        for (String str : accessStr){
            if (str.equals(path)){
                filterChain.doFilter(req, resp);
            }
        }

        for (String str : noAccessStr){
            if (str.equals(path)){
                String username = (String)session.getAttribute("username");
                if (username != null) {
                    filterChain.doFilter(req, resp);
                }else {
                    resp.sendRedirect(req.getContextPath()+"/index.jsp");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
