package com.kgc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       /* HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        String uri = request.getRequestURI();//uri:/page/login.jsp
        String s = uri.substring(uri.lastIndexOf("/") + 1);//s:login.jsp
        if(s.equals("login.jsp")||s.equals("LoginAction")){
            chain.doFilter(req, resp);
        }else {
            HttpSession session = request.getSession();
            Object o = session.getAttribute("login.jsp");
            if(o==null){
                response.sendRedirect("login.jsp");
            }else {
                chain.doFilter(req, resp);
            }*/




    }

    public void init(FilterConfig config) throws ServletException {

    }

}
