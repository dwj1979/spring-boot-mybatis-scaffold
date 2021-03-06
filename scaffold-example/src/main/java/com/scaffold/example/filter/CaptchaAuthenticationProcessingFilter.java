package com.scaffold.example.filter;

import com.google.code.kaptcha.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.springframework.security.authentication.BadCredentialsException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sungang on 2017/8/19.
 */
@Slf4j
public class CaptchaAuthenticationProcessingFilter implements Filter {


    private String captchaParameter = "captcha";
    private boolean state = Boolean.TRUE;


    public CaptchaAuthenticationProcessingFilter(boolean state) {
        this.state = state;
    }

    protected String obtainCaptcha(HttpServletRequest request) {
        return request.getParameter(captchaParameter);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

//        if (state) {
//            String captcha = this.obtainCaptcha(request);
//            String sessionCaptcha = (String) request.getSession(false).getAttribute(Constants.KAPTCHA_SESSION_KEY);
//            if (StringUtils.isBlank(captcha)) {
//                log.error("Captcha is Invalid,params={}", ToStringBuilder.reflectionToString(request.getParameterMap()));
//                throw new BadCredentialsException("Captcha is NULL !");
//            }
//
//            if (StringUtils.isNotBlank(sessionCaptcha)
//                    && sessionCaptcha.equalsIgnoreCase(captcha)) {
//                log.error("Captcha is Invalid,params={}", ToStringBuilder.reflectionToString(request.getParameterMap()));
//                throw new BadCredentialsException("Captcha is Invalid !");
//            }
//        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
