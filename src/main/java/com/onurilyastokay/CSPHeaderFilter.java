package com.onurilyastokay;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CSPHeaderFilter implements Filter {

    private String contentSecurityPolicy;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        contentSecurityPolicy = filterConfig.getInitParameter("contentSecurityPolicy");
        if (contentSecurityPolicy == null) {
            // Default CSP value if not provided
            contentSecurityPolicy = "default-src 'self'; script-src 'self'; style-src 'self' 'unsafe-inline'; img-src 'self'; object-src 'none'; frame-ancestors 'self';";
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (response instanceof HttpServletResponse) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setHeader("Content-Security-Policy", contentSecurityPolicy);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
