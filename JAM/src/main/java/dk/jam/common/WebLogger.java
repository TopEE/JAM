/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam.common;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author mads
 */
@WebFilter(urlPatterns = "/*")
public class WebLogger implements Filter{
    
    Logger logger = Logger.getLogger(WebLogger.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("WebLogger.init called!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("WebLogger.doFilter called!");
        long start = System.currentTimeMillis();
        
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        String scheme = request.getLocalAddr();
        logger.log(Level.INFO, "Scheme = {0}", scheme);
        logger.log(Level.INFO, "WebLogger.doFilter took {0} msec", (end-start));
        
    }

    @Override
    public void destroy() {
        logger.info("WebLogger.destroy called!");
    }
    
    
    
}
