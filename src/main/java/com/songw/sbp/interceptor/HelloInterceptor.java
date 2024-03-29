package com.songw.sbp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HelloInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("LoginInterceptor.pre>>" + request.getRequestURI());
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//System.out.println();
		
		
		HandlerMethod method = (HandlerMethod)handler;
		System.out.println("HelloInterceptor.post>> " + method.getBean()
				 + ", method =" + method.getMethod()
				);
	
	}
	
}
