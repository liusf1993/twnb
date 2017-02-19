package com.lsf.twnb.filter;

import com.lsf.twnb.constants.SessionConstants;
import com.lsf.twnb.constants.SystemConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * liusf1993
 */
public class CommonFilter implements Filter {
    private String ignorePatterns;
    public void init(FilterConfig filterConfig) throws ServletException {
        ignorePatterns=".*(login|register|resources|index|).*";
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) res;
        //if the request path is not homepage and user hasn't login, redirect to homepage
        if(!(request.getServletPath().matches(ignorePatterns))
                &&request.getSession().getAttribute(SessionConstants.USER)==null){
            response.sendRedirect(request.getContextPath()+SystemConstants.HOME_PATE);
        }else {
            //set context path in attributes
            request.setAttribute(SystemConstants.CONTEXT_PATH_ATTRIBUTE,request.getContextPath());
            chain.doFilter(request, res);
        }
    }

    public void destroy() {

    }
}
