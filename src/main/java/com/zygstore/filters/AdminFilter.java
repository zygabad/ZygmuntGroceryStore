package com.zygstore.filters;

import java.io.IOException;


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

import org.apache.log4j.Logger;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */

public class AdminFilter implements Filter {
    public AdminFilter() {
        out.println("I'm going throug filter AdminFilter");
    }

    final static Logger logger = Logger.getLogger(AdminFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        try {
            httpResponse.sendRedirect("/admin.xhtml");
            out.println("Przeszedlem przez filtr AdminFilter");
            logger.info("Passed through AdminFilter");
        } catch (Exception exception) {
            //TODO log error here and pass it further redirect to error page
            logger.error("Something went wrong, stacktrace: ", exception);
            //TODO throw your own exception
            if (exception.toString().equals("java.lang.NullPointerException")) {
                try {
                    throw new Exception("ExceptionID 1234");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //TODO use finally
            chain.doFilter(httpRequest, response);
        }
    }

    @Override
    public void destroy() {

    }

}
