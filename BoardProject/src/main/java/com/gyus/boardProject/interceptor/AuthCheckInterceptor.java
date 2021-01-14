package com.gyus.boardProject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle진입");
		HttpSession session = request.getSession(false);
		if(session.getAttribute("authInfo") == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		return true;
	}
}
