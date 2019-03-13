package com.zygstore.filters;

import java.io.IOException;
import java.util.logging.LogRecord;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static java.lang.System.out;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class ErrorResultFilter implements Filter {
    public ErrorResultFilter() {
        out.println("I'm going throug filter ErrorResult");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        out.println("Przeszedlem przez filtr ErrorResultFilter");
        chain.doFilter(httpRequest, response);
        //httpRequest.
        //out.println();

    }

    @Override
    public void destroy() {

    }

}
