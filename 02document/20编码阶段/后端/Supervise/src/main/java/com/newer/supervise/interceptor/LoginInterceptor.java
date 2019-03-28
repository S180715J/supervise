package com.newer.supervise.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static Set<String> pageSet = new HashSet<>();
	
	static {
		pageSet.add("index.html");
		pageSet.add("/logins");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof DefaultServletHttpRequestHandler) {
			return true;
		}
		// 获取当前页面URL和请求地址
		String uri = request.getRequestURI();
		String servletPath = request.getServletPath();
		// 若用户处在未登录不可访问的页面
		if (!(pageSet.contains(uri) || pageSet.contains(servletPath))) {
			// 从session域中获取用户对象
			Object user = request.getSession().getAttribute("user");
			// 判断用户是否为空
			if (user == null) {
				response.sendRedirect(request.getContextPath() + "index.html");
				return false;
			}
		}
		return true;
	}
}
